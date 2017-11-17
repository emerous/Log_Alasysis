package com.fx.la.controller;

import com.fx.la.common.ReadFileThread;
import com.fx.la.entity.BaseInfo;
import com.fx.la.entity.EmergencyData;
import com.fx.la.entity.ErrorData;
import com.fx.la.entity.InfoData;
import com.fx.la.entity.statistic.CommonApiMsg;
import com.fx.la.mapper.EmergencyMapper;
import com.fx.la.service.BaseInfoService;
import com.fx.la.service.EmergencyDataService;
import com.fx.la.service.ErrorDataService;
import com.fx.la.service.InfoDataService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    BaseInfoService service;
    @Autowired
    EmergencyDataService emergencyDataService;
    @Autowired
    ErrorDataService errorDataService;
    @Autowired
    InfoDataService infoDataService;

    @RequestMapping("/raw")
    public void readAndWrite(){
        ExecutorService service = Executors.newFixedThreadPool(1);
//        service.execute(new ReadFileThread("E:\\转正-课题\\Api.tar\\Api","debug",rabbitTemplate));
//        service.execute(new ReadFileThread("E:\\转正-课题\\Api.tar\\Api","emergency",rabbitTemplate));
//        service.execute(new ReadFileThread("E:\\转正-课题\\Api.tar\\Api","error",rabbitTemplate));
//        service.execute(new ReadFileThread("E:\\转正-课题\\Api.tar\\Api","info",rabbitTemplate));
        service.shutdown();
    }

    @RequestMapping("/addBaseInfo")
    public void addBaseInfo(){
        BaseInfo baseInfo = new BaseInfo();
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time="1970-01-06 11:45:55";

        Date date = null;
        try {
            date = format.parse(time);
        }catch (Exception e){
        }
        baseInfo.setTimestamp(date.getTime());
        baseInfo.setApi("L_L");
        service.addBaseInfo(baseInfo);
    }
    @RequestMapping("/getMsgByTimeRange")
    public List<CommonApiMsg> getCountByTimeRange(){
        return service.getCountByTimeRange(1506931200311l,1507050003473l);
    }

    @RequestMapping("/addEmergencyData")
    public void addEmergencyData(){
        EmergencyData emergency = new EmergencyData();
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time="1970-01-06 11:45:55";

        Date date = null;
        try {
            date = format.parse(time);
        }catch (Exception e){
        }
        emergency.setTimestamp(date.getTime());
        emergency.setApi("L_L");
        emergency.setMsg("数据库操作发生异常");
        emergencyDataService.addEmergencyData(emergency);
    }
    @RequestMapping("/getEmerCountByTimeRange")
    public List<CommonApiMsg> getEmerCountByTimeRange(){
        return emergencyDataService.getCountByTimeRange(1506931200311l,1507050003473l);
    }

    @RequestMapping("/addErrorData")
    public void addErrorData(){
        ErrorData errorData= new ErrorData();
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time="1970-01-06 11:45:55";

        Date date = null;
        try {
            date = format.parse(time);
        }catch (Exception e){
        }
        errorData.setTimestamp(date.getTime());
        errorData.setApi("KKK");
        errorData.setMsg("unkown error");
        errorDataService.addErrorData(errorData);
    }
    @RequestMapping("/addInfoData")
    public void addInfoData(){
        InfoData infoData = new InfoData();
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time="1970-01-06 11:45:55";

        Date date = null;
        try {
            date = format.parse(time);
        }catch (Exception e){
        }
        infoData.setTimestamp(date.getTime());
        infoData.setMsg("wwwwwwwwwwaaaaaaaaaaa");
        infoDataService.addInfoData(infoData);
    }
}
