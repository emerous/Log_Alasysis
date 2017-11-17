package com.fx.la.parselog;

public class ProcessEmergencyLogs extends ParseLogs {
    @Override
    public String match(String path, String msg) {
        String step = matchAPI(path);
        if("".equals(step)){
            System.out.println(path);
        }
        if(msg.contains("云服务Token验证接口超时")){
            return step+"|1";
        }
        if(msg.contains("用户初始化失败，即将进入回滚")){
            return step+"|2";
        }
        if(msg.contains("用户未选中对应商品id")){
            return step+"|3";
        }
        if(msg.contains("库存")){
            return step+"|4";
        }
        if(msg.contains("手机验证码发送接口调用失败"))
        {
            return step+"|5";
        }
        if(msg.contains("不匹配,此商品无详情信息")){
            return step+"|6";
        }
        if(msg.contains("积分")){
            return step+"|7";
        }
        if(msg.contains("调用联璧金融接口")){
            return step+"|8";
        }
        System.out.println(msg);
        return step+"|0";
    }
    //    @Override
//    public String match(String path,String msg) {
//
//        //验证k码出错  step= K_Verifi_Error
//        if(msg.contains("用户插入验证成功k码进入数据库失败")||msg.contains("该k码已失效，接口似乎有被黑客攻击的可能")||msg.contains("紧急异常、k码验证接口接口调用出错")
//                ||msg.contains("k码验证接口被单个用户脚本访问，接口似乎有被黑客攻击的可能")||msg.contains("云服务手机验证码发送接口调用失败")){
//            return "K_Verifi_Error"+"|3";
//        }
//
//        //领取特权商品出错 step= PG_Error
//        if(msg.contains("数据库运行情况，当日领取量已达上限")||msg.contains("异常原因:1.数据库异常、2.奖品库存不足、3.用户脚本攻击，可能原因为")||msg.contains("数据库异常，用户插入领取k码商品记录异常")
//                ||msg.contains("失败,此商品库存不足")||msg.contains("、奖品库存量不足")||msg.contains("用户当天已领取过k码、或用户通过脚本攻击接口")){
//            return "PG_Error"+"|3";
//        }
//
//
//        //抽奖出错 step = L_Error
//        if(msg.contains("库存不足！")||msg.contains("数据库异常-insertUser")||msg.contains("数据库异常、sql=")||msg.contains("不匹配,此商品无详情信息")
//                ||msg.contains("奖品id-奖品库存量不足")||msg.contains("抽奖失败，奖品id")||msg.contains("抽奖失败，系统繁忙，类脚本攻击")
//                ||msg.contains("日志信息:云服务Token验证接口超时，请立即修复! ")||msg.contains("预更新用户总积分、预插入用户积分消耗记录失败！")||msg.contains("update用户总积分失败")){
//            return "L_Error"+"|3";
//        }
//
//        //用户初始化失败step=U_Init_Error
//        if(msg.contains("用户初始化失败，即将进入回滚!")){
//            return "U_Init_Error"+"|3";
//        }
//        System.out.println(msg);
//        return "emergency log";
//    }
}
