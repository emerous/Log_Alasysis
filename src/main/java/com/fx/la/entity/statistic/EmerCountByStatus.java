package com.fx.la.entity.statistic;

public class EmerCountByStatus {
    private int[][] ecbs;
    public EmerCountByStatus(int n){
        ecbs = new int[2][n];
    }
    public void setVal(int k,int v){
        ecbs[0][k]=k;
        ecbs[1][k]=v;
    }
    public int[][] getEcbs() {
        return ecbs;
    }

    public void setEcbs(int[][] ecbs) {
        this.ecbs = ecbs;
    }
}
