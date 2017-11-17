package com.fx.la.parselog;

public class ProcessDebugLogs extends ParseLogs {
    @Override
    public String match(String path, String msg) {
        //超类中实现了对API的匹配
        String step = matchAPI(path);
        if(msg.contains("request method invalidate")||msg.contains("请求方法错误")||msg.contains("参数错误")
                ||msg.contains("参数缺失")||msg.contains("参数不合法")||msg.contains("token失效")) {
            return step + "|2";
        }
        if(msg.contains("已经")||msg.contains("超过")||msg.contains("未")||msg.contains("失败")||msg.contains("失效")
                ||msg.contains("无")||msg.contains("没有")||msg.contains("不足")||msg.contains("已用完")||msg.contains("异常")){
            return step + "|2";
        }
        if("".equals(step)){
            System.out.println(path);
        }
        return step + "|1";
    }
    //    @Override
//    public String match(String path,String msg) {
//
////        int status;
////        String step;
//        //请求--公共信息，step=R_Pub
//        if(msg.contains("request method invalidate")||msg.contains("请求方法错误")||msg.contains("参数错误")
//                ||msg.contains("参数缺失")||msg.contains("参数不合法")||msg.contains("token失效")){
//            return "R_Pub"+"|2";
//        }
//        if(msg.contains("用户开始访问")){
//            return "R_Pub"+"|1";
//        }
//        //k码基础 step=K_Base
//        if(msg.contains("k码已经验证通过")||msg.contains("当日k码验证次数超过3次")){
//            return "K_Base"+"|2";
//        }
//        if(msg.contains("用户可使用k码特权验证功能")){
//            return "K_Base"+"|1";
//        }
//        //k码验证状态 step=K_Status
//        if(msg.contains("用户已通过K码验证")){
//            return "K_Status"+"|1";
//        }
//        if(msg.contains("用户未通过K码验证")){
//            return "K_Status"+"|2";
//        }
//        //k码验证基础 step=K_Verifi_Base
//        if(msg.contains("用户手机验证码验证成功")||msg.contains("手机验证码:")||msg.contains("手机短信验证码发送成功,验证码:")||msg.contains("用户开始访问 \"立即使用\" 数据上报接口")
//                ||msg.contains("用户上报 \"立即使用\" 数据成功")){
//            return "K_Verifi_Base"+"|1";
//        }
//        if(msg.contains("用户手机验证码验证失败")||msg.contains("用户当日k码验证次数已超过上限")||msg.contains("手机短信验证码发送失败,请确认k码符合标准格式")){
//            return "K_Verifi_Base"+"|2";
//        }
//        //开始验证k码，请求结果 step= K_Verifi_result
//        if(msg.contains("用户k码在联璧金融激活成功")||msg.contains("用户k码在斐讯路由验证成功")||msg.contains("k码已验证通过")){
//            return "K_Verifi_result"+"|1";
//        }
//        if(msg.contains("该k码已失效")||msg.contains("该k码未在联璧金融激活")||msg.contains("debug_info:该K码已失效")){
//            return "K_Verifi_result"+"|2";
//        }
//
//
//        //通过k码，领取特权商品 step=PG_K_Base
//        if(msg.contains("用户当日已领取k码特权奖品")||msg.contains("用户点击免费领取奖品，k码未验证通过")
//                ||msg.contains("当前库存量:")||msg.contains("当前事务内商品库存量")){
//            return "PG_K_Base"+"|2";
//        }
//        if(msg.contains("用户k码验证已通过，即将进入免费领取核心业务逻辑")||msg.contains("用户开始请求免费领取k码特权商品接口")||msg.contains("用户锁定当日免费领取k码特权商品令牌(机会)")
//                ||msg.contains("用户开始执行免费领取k码特权商品事务")||msg.contains("用户请求k码特权商品列表接口")||msg.contains("当前页无k码特权商品数据")||msg.contains("当前页没有有效商品或奖品数据！")){
//            return "PG_K_Base"+"|1";
//        }
//        //领取商品 step= PG_Receive
//        if(msg.contains("用户开始乐观锁预领取商品id")||msg.contains("用户选中商品")||msg.contains("用户选中并成功更新商品id")
//                ||msg.contains("用户免费领取奖品成功!商品id")||msg.contains("获取k码特权商品成功,用户请求结束时间")||msg.contains("获取用户已得商品成功！")){
//            return "PG_Receive"+"|1";
//        }
//
//        //-------抽奖
//        //获取用户剩余抽奖次数 step=L_Base
//        if(msg.contains("用户当前状态可抽奖、抽奖剩余次数")||msg.contains("用户开始请求删除过期奖品请求")||msg.contains("用户删除")){
//            return "L_Base"+"|1";
//        }
//        if(msg.contains("积分不足,当前总积分")||msg.contains("用户抽奖次数已用完，用户当前总积分")||msg.contains("此用户没有已获得的k码特权商品或抽奖奖品信息！")){
//            return "L_Base"+"|2";
//        }
//        //抽奖 step= L_Lotto
//        if(msg.contains("用户开始进行乐观锁抽奖核心逻辑")||msg.contains("用户开始进行乐观锁抽奖，获取抽奖令牌(机会)成功")||msg.contains("预更新用户总积分")||msg.contains("预插入用户积分消耗记录")
//                ||msg.contains("用户预抽奖、抽奖id")||msg.contains("用户预抽奖成功,乐观抽取")||msg.contains("用户判断预抽奖奖品库存量为")||msg.contains("用户预更新商品库存成功，库存为")
//                ||msg.contains("用户预中奖奖品类型为:卡券类")||msg.contains("用户开始预中奖卡券类奖品item")||msg.contains("用户开始预中奖卡券类奖品item成功")||msg.contains("用户乐观锁更改预中奖卡券类奖品item被领取状态成功")
//                ||msg.contains("用户开始预中奖积分类奖品,用户总积分增长值为")||msg.contains("用户中奖成功")||msg.contains("用户开始请求奖品详情接口")||msg.contains("用户获取奖品详情信息成功")||msg.contains("用户开始请求奖品列表数据")){
//            return "L_Lotto"+"|1";
//        }
//        if(msg.contains("预更新用户总积分、预插入用户积分消耗记录失败！")||msg.contains("2-奖品每日被抽奖次数>=每日奖品被抽上限")||msg.contains("抽奖失败，奖品")){
//            return "L_Lotto"+"|2";
//        }
//        System.out.println(msg);
//        return "debug log";
//    }
}
