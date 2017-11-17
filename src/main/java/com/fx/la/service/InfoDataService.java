package com.fx.la.service;

import com.fx.la.entity.InfoData;
import com.fx.la.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoDataService {
    @Autowired
    InfoMapper infoMapper;
    public void addInfoData(InfoData infoData){
        infoMapper.addInfoData(infoData);
    }
}
