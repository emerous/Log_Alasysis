package com.fx.la.mapper;

import com.fx.la.entity.BaseInfo;
import com.fx.la.entity.EmergencyData;
import com.fx.la.entity.statistic.CommonApiMsg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component("EmergencyDataMapper")
public interface EmergencyMapper {
    //查找
//    String getNameById(int id);
    List<CommonApiMsg> getCountByTimeRange(Map<String ,Long> map);
    List<CommonApiMsg> getCountByStatus(Map<String ,Long> map);
//    int userCount(Map<String, Object> para);
    //添加
    void addEmergencyData(EmergencyData emergencyData);
    //更新
    //删除
}
