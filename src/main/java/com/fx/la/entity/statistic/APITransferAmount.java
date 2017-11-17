package com.fx.la.entity.statistic;

import java.io.Serializable;

public class APITransferAmount implements Serializable {
    /**
     * 接口按照如下顺序进行显示
     *0 L_ULLC       用户剩余抽奖机会
     *1 K_KAG        k码特权商品
     *2 L_L          抽奖
     *3 URL_RR
     *4 URL_RD
     *5 URL_FER
     *6 UKR_UKRS
     *7 K_KV
     *8 K_PVS
     *9 K_CKCS
     *10 K_KGG
     *11 S_TS
     *12 M_MI
     *13 C_CI
     */

    //接口调用中3种情况数量
    private int[] normal;//正常
    private int[] userMistake;//用户操作有误提示
    private int[] programError;//程序出错
    public APITransferAmount(int apiAamount){
        normal = new int[apiAamount];
        userMistake = new int[apiAamount];
        programError = new int[apiAamount];
    }
    public void setVal(String type,String api,int val){
        int index = getIndex(api);
        if(index==-1){
            return;
        }
        if(type.startsWith("normal")){
            normal[index] = val;
        }else if(type.startsWith("userMis")){
            userMistake[index] = val;
        }else{
            programError[index] = val;
        }
    }
    public static int getIndex(String api){
        if(api.startsWith("L_ULLC")){
            return 0;
        }else if(api.startsWith("K_KAG")){
            return 1;
        }else if(api.startsWith("L_L")){
            return 2;
        }else if(api.startsWith("URL_RR")){
            return 3;
        }else if(api.startsWith("URL_RD")){
            return 4;
        }else if(api.startsWith("URL_FER")){
            return 5;
        }else if(api.startsWith("UKR_UKRS")){
            return 6;
        }else if(api.startsWith("K_KV")){
            return 7;
        }else if(api.startsWith("K_PVC")){
            return 8;
        }else if(api.startsWith("K_CKCS")){
            return 9;
        }else if(api.startsWith("K_KGG")){
            return 10;
        }else if(api.startsWith("S_TS")){
            return 11;
        }else if(api.startsWith("M_MI")){
            return 12;
        }else if(api.startsWith("C_CI")){
            return 13;
        }
        System.out.println(api);
        return -1;
    }
    public int[] getNormal() {
        return normal;
    }

    public void setNormal(int[] normal) {
        this.normal = normal;
    }

    public int[] getUserMistake() {
        return userMistake;
    }

    public void setUserMistake(int[] userMistake) {
        this.userMistake = userMistake;
    }

    public int[] getProgramError() {
        return programError;
    }

    public void setProgramError(int[] programError) {
        this.programError = programError;
    }

}
