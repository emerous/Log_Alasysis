package com.fx.la.service;

import com.fx.la.entity.ErrorData;
import com.fx.la.mapper.ErrorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorDataService {
    @Autowired
    ErrorMapper errorMapper;
    public void addErrorData(ErrorData errorData){
        errorMapper.addErrorData(errorData);
    }
}
