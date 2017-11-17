package com.fx.la.common;

import com.fx.la.parselog.ParseLogsFactory;

public class ParseField {

    public static String[] parseField(String field){
        String []fields = field.split("\\|");
        String type = fields[0].trim();
        String[] result;
        int len = fields.length;
        String msg="";
        if(type.equals("debug")){
            result = new String[4];
            if(fields[len-1].startsWith(" param_list:{")||fields[len-1].startsWith(" 列表数据如下所示")||fields[len-1].startsWith(" pageNo:")
                    ||fields[len-1].startsWith(" 上报数据结构")) {
                msg = ParseLogsFactory.getDebug().match(fields[4],fields[len-2]);
            }else{
                msg = ParseLogsFactory.getDebug().match(fields[4],fields[len-1]);
            }

            if(msg.equals("debug log")){
                System.out.println(msg);
            }
            //获取与数据库匹配的debug字段，写入数据库
            result[0]=fields[0].trim();
            result[1]=fields[2].trim();
//            String uid="0";
//            String [] temp= fields[6].split(":");
//            if(temp.length>1&&temp[1].length()>3){
//                uid=temp[1].trim();
//            }
            result[2]=fields[1];
            result[3]=msg;
            return result;

        }
        if(type.equals("emergency")){
            result = new String[5];
            msg = ParseLogsFactory.getEmergency().match(fields[4],fields[len-1]);
            if(msg.equals("emergency log")){
                System.out.println(msg);
            }
            result[0]=fields[0].trim();
            result[1]=fields[2].trim();
            String[] te = msg.split("\\|");
            result[2]=te[0];
            result[3]=te[1];
            result[4]=fields[len-1].trim();
            return result;
        }
        if(type.equals("error")){
            result = new String[4];
            msg = ParseLogsFactory.getError().match(fields[4],fields[len-1]);
            if(msg.equals("error log")){
                System.out.println(msg);
            }
            result[0]=fields[0].trim();
            result[1]=fields[2].trim();
            result[2]=msg;
            result[3]=fields[len-1].trim();
            return result;
        }
        if(type.equals("info")){
            System.out.println("收到Info信息:---------"+field);
            result = new String[3];
            msg =ParseLogsFactory.getInfo().match(fields[4],fields[len-1]);
            result[0]=fields[0].trim();
            result[1]=fields[2].trim();
            result[2]=msg;
            return result;
        }
        return null;
    }
}
