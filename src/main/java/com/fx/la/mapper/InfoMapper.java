package com.fx.la.mapper;

import com.fx.la.entity.ErrorData;
import com.fx.la.entity.InfoData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("InfoMapper")
public interface InfoMapper {
    //查找
//    String getNameById(int id);
//    int userCount(Map<String, Object> para);
    //添加
    void addInfoData(InfoData infoData);
    //更新
    //删除
}
