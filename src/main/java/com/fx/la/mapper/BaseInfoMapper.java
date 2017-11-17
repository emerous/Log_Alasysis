package com.fx.la.mapper;

import com.fx.la.entity.BaseInfo;
import com.fx.la.entity.statistic.CommonApiMsg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Component("baseInfoMapper")
public interface BaseInfoMapper {
    //查找
    BaseInfo getMsgByTime(long time);
    BaseInfo[] getMsgsByTimeSection(long time);
    List<CommonApiMsg> getCountByTimeRange(Map<String ,Long> map);
//    int userCount(Map<String, Object> para);
    //添加
    void addBaseInfo(BaseInfo baseInfo);
    //更新
    void updateBaseInfo(BaseInfo baseInfo);
    //删除
}
