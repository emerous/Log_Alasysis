package com.fx.la.common;

import com.fx.la.entity.BaseInfo;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class DebugCountAnHour {

//    private static BaseInfo L_ULLC1;
//    private static BaseInfo L_ULLC2;
//    private static BaseInfo K_KAG1;
//    private static BaseInfo K_KAG2;
//    private static BaseInfo L_L1;
//    private static BaseInfo L_L2;
//    private static BaseInfo URL_RR1;
//    private static BaseInfo URL_RR2;
//    private static BaseInfo URL_RD1;
//    private static BaseInfo URL_RD2;
//    private static BaseInfo URL_FER1;
//    private static BaseInfo URL_FER2;
//    private static BaseInfo UKR_UKRS1;
//    private static BaseInfo UKR_UKRS2;
//    private static BaseInfo K_KV1;
//    private static BaseInfo K_KV2;
//    private static BaseInfo K_PVS1;
//    private static BaseInfo K_PVS2;
//    private static BaseInfo K_CKCS1;
//    private static BaseInfo K_CKCS2;
//    private static BaseInfo K_KGG1;
//    private static BaseInfo K_KGG2;
//    private static BaseInfo S_TS1;
//    private static BaseInfo S_TS2;
//    private static BaseInfo M_MI1;
//    private static BaseInfo M_MI2;
//    private static BaseInfo C_CI1;
//    private static BaseInfo C_CI2;

    public static long recordTime=0;
    public static void setRecordTime(long recordTime) {
        DebugCountAnHour.recordTime = recordTime;
    }

    public static Map<String,Integer> apiCountMap = new HashMap<>();

    public static void setApiCount(String api){
        if(null!=apiCountMap.get(api)){
            int val = apiCountMap.get(api);
            apiCountMap.put(api,val+1);
        }else{
            apiCountMap.put(api,1);
        }
    }

    public static boolean isCurrentTime(long time){
        if(time>=recordTime){
            if(time-recordTime<3600000){
                return true;
            }
        }
        return false;
    }

}
