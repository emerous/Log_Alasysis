package com.fx.la.mapper;

import com.fx.la.entity.BaseInfo;
import com.fx.la.entity.ErrorData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("ErrorMapper")
public interface ErrorMapper {
    //查找
//    String getNameById(int id);
//    int userCount(Map<String, Object> para);
    //添加
    void addErrorData(ErrorData errorData);
    //更新
    //删除
}
