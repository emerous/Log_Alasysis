package com.fx.la.service;

import com.fx.la.entity.EmergencyData;
import com.fx.la.entity.statistic.CommonApiMsg;
import com.fx.la.mapper.EmergencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmergencyDataService {
    @Autowired
    EmergencyMapper emergencyMapper;

    public void addEmergencyData(EmergencyData emergencyData){
        emergencyMapper.addEmergencyData(emergencyData);
    }
    public List<CommonApiMsg> getCountByTimeRange(long start,long end){
        Map<String,Long>  map = new HashMap<>();
        map.put("start" ,start);
        map.put("end",end);
        return emergencyMapper.getCountByTimeRange(map);
    }
    public List<CommonApiMsg> getCountByStatus(long start,long end){
        Map<String,Long>  map = new HashMap<>();
        map.put("start" ,start);
        map.put("end",end);
        return emergencyMapper.getCountByStatus(map);
    }
}
