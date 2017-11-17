package com.fx.la.entity.statistic;

public class CommonApiMsg {
    private String api;
    private int count;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString(){
        return "{api:"+api+",count:"+count+"}";
    }
}
