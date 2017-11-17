package com.fx.la.entity.statistic;

public class EmerCountChangeWithTime {

    private int[][] emerCountByTime;//出错随时间变化情况
    public EmerCountChangeWithTime(int apiAmount, int n){
        emerCountByTime = new int[apiAmount][n];
    }
    public void setVal(String api,int val,int pos){
        int index = APITransferAmount.getIndex(api.split("\\|")[0]);
        emerCountByTime[index][pos]=val;
    }
    public int[][] getEmerCountByTime() {
        return emerCountByTime;
    }

    public void setEmerCountByTime(int[][] emerCountByTime) {
        this.emerCountByTime = emerCountByTime;
    }
}
