package com.fx.la.parselog;

public class ProcessInfoLogs extends ParseLogs {
    @Override
    public  String match(String path,String msg) {
        if(msg.contains("用户k码在斐讯路由验证成功")){
            return msg;
        }else{
            System.out.println(path);
        }
        return "info log";
    }
}
