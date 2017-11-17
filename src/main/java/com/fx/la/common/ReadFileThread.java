package com.fx.la.common;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileThread implements Runnable {

    //filePathList需要读取的文件列表
    private List<File> filePathsList = new ArrayList<>();
    private int index;
    private RabbitTemplate rabbitTemplate;
//    @Autowired
//    RabbitTemplate rabbitTemplate;

    public ReadFileThread(String path, String type, RabbitTemplate rabbitTemplate) {
        index=0;
        File file = new File(path);
        getFileList(file, type);
        this.rabbitTemplate=rabbitTemplate;
    }
    //线程启动时获取要读取文件的列表
    private void getFileList(File file, String type) {
        File[] filePaths = file.listFiles();
        for (File s : filePaths) {
            if (s.getName().contains(type)) {
                filePathsList.add(s);
            }
        }
    }

    @Override
    public void run() {
        File file ;
        String line = null;
        String flag="";
        while (index < filePathsList.size()) {
            //读取当前文件，并按行放入mq中
            file = filePathsList.get(index);
            index++;
            try {
                FileInputStream inputStream = new FileInputStream(file.getPath());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String routKey;

                while((null!=(line=bufferedReader.readLine())))
                {
                    if(line.startsWith("debug")) {
                        flag = "debug";
                        routKey="queue_debug";
                    }else{
                        routKey="queue_others";
                    }
                    rabbitTemplate.convertAndSend("DirectExchange", routKey, line);
                }


            }catch (IOException e){

            }

        }
        //最后一个文件已经读完，发送结束计数标记
        if("debug".equals(flag)) {
            rabbitTemplate.convertAndSend("DirectExchange", "queue_debug", "flagtoend");
        }
    }
}
