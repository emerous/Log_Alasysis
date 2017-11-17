package com.fx.la.service;

import com.fx.la.entity.BaseInfo;
import com.fx.la.entity.statistic.CommonApiMsg;
import com.fx.la.mapper.BaseInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BaseInfoService {
    @Autowired
    BaseInfoMapper bim;

    public void addBaseInfo(BaseInfo baseInfo){
        bim.addBaseInfo(baseInfo);
    }
    public BaseInfo getMsgByTime(long time){return bim.getMsgByTime(time);}
    public void updateBaseInfo(long time,Map<String,Integer> map){
        BaseInfo[] baseInfos = bim.getMsgsByTimeSection(time);
        for(int i=0;i<baseInfos.length;i++){
            if(null!=map.get(baseInfos[i].getApi())){
                baseInfos[i].setAmount(baseInfos[i].getAmount()+map.get(baseInfos[i].getApi()));
                bim.updateBaseInfo(baseInfos[i]);
            }
        }
    }
    public void addBaseInfoMap(long time,Map<String,Integer> map){
        BaseInfo baseInfo = new BaseInfo();
        Iterator<Map.Entry<String,Integer>> entries = map.entrySet().iterator();
        long local = time;
        while (entries.hasNext()){
            baseInfo.setBaseId(UUID.randomUUID().toString());
            Map.Entry<String,Integer> entry = entries.next();
            baseInfo.setTimestamp(local++);
            baseInfo.setApi(entry.getKey());
            baseInfo.setAmount(entry.getValue());
            bim.addBaseInfo(baseInfo);
        }

    }
    public List<CommonApiMsg> getCountByTimeRange(long start,long end){
        Map<String ,Long> map = new HashMap<>();
        map.put("start",start);
        map.put("end",end);
        return  bim.getCountByTimeRange(map);
    }

}
