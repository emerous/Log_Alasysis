package com.fx.la.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        //    String s  = "debug | 30708 | 1506787200.156 | 2017:10:01 00:00:00 | path:/Lotto/userLottoLeftChance | uip:192.168.61.2｜ uid:1461879｜debug_info:用户开始访问获取用户当前剩余抽奖次数接口｜ param_list:{\"token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIxNDYxODc5IiwiY29kZSI6ImZlaXh1bi5TSF83IiwidHlwZSI6ImFjY2Vzc190b2tlbiIsImlzcyI6IlBoaWNvbW0iLCJuYmYiOjE1MDY1ODk4NjMsImV4cCI6MTUwNzEwODI2MywicmVmcmVzaFRpbWUiOiIyMDE3LTA5LTMwIDE3OjExOjAzIn0.VUN7OidlAL8w8SaO0R19PgyAZVA3Ta76oupFJ48oLhY\"} \n";
        String s = "emergency | 6202 | 1508285553.338 | 2017:10:18 08:12:33 | path: /Kcode/kcodeGoodsGrants | uip:192.168.61.2 ｜ uid:79626153｜debug_info:用户未选中对应商品id Item:17,异常原因:1.数据库异常、2.奖品库存不足、3.用户脚本攻击，可能原因为2 \n";
        String[] ss = s.split("\\|");

        System.out.println(ss);
        Map<String, Integer> map = new HashMap<>();
        map.put("L_L", 22);
        if (null == map.get("L_O")) {
            System.out.println("---------为空");
            int k = map.get("L_L");
            map.put("L_L", ++k);
            map.clear();
            System.out.println(map.get("L_L"));
        }

        long timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time1 =1506862799935L;
        long time2 = 1506862800906L;
        String date = df.format(timeMillis);
        String date1 = df.format(time1);
        String date2 = df.format(time2);
        System.out.println("--------"+date1);
        System.out.println("---------"+date2);
        Date d=null;
        try {
           d = df.parse(date);
        }catch (Exception e){

        }
        d.setMinutes(00);
        d.setSeconds(00);
        d.setHours(12);
        long temp = d.getTime();
        System.out.println(temp);
        d.setHours(13);
        System.out.println(d.getTime());
        System.out.println(d.getTime()-temp);

    }
}
