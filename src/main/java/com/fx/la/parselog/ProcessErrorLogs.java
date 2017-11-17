package com.fx.la.parselog;

public class ProcessErrorLogs extends ParseLogs {
    @Override
    public String match(String path,String msg) {
        //error级别日志数据比较单一，
//        if(msg.contains("日志信息:更新用户积出错，即将进入回滚!出错SQL")){
//            return "Error";
//        }else{
//
//        }
        String step = matchAPI(path);
        if("".equals(step)){
            System.out.println(path);
        }
        return step;
    }
}
