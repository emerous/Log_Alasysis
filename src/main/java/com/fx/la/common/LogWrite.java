package com.fx.la.common;

import com.fx.la.entity.BaseInfo;
import com.fx.la.entity.EmergencyData;
import com.fx.la.entity.ErrorData;
import com.fx.la.entity.InfoData;
import com.fx.la.service.BaseInfoService;
import com.fx.la.service.EmergencyDataService;
import com.fx.la.service.ErrorDataService;
import com.fx.la.service.InfoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class LogWrite {
    @Autowired
    BaseInfoService baseInfoService;
    @Autowired
    EmergencyDataService emergencyDataService;
    @Autowired
    ErrorDataService errorDataService;
    @Autowired
    InfoDataService infoDataService;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void write(String[] msg){
        if("debug".equals(msg[0])||"writeNow".equals(msg[0])){
            if("writeNow".equals(msg[0])){
                //最后所有文件读取完成后标记提交
                baseInfoService.addBaseInfoMap(DebugCountAnHour.recordTime,DebugCountAnHour.apiCountMap);
                DebugCountAnHour.apiCountMap.clear();
            }else {
                long te = (long) ((Double.parseDouble(msg[1])) * 1000);
                if (DebugCountAnHour.isCurrentTime(te)) {
                    DebugCountAnHour.setApiCount(msg[3]);
                } else {
                    System.out.println(te);
                    if(DebugCountAnHour.apiCountMap!=null) {
                        BaseInfo baseInfo = baseInfoService.getMsgByTime(DebugCountAnHour.recordTime);
                        if(null==baseInfo) {
                            baseInfoService.addBaseInfoMap(DebugCountAnHour.recordTime, DebugCountAnHour.apiCountMap);
                        }else{
//                                baseInfoService.updateBaseInfo(DebugCountAnHour.recordTime,DebugCountAnHour.apiCountMap);
                                System.out.println(DebugCountAnHour.apiCountMap.toString());
                        }
                        System.out.println("写入一个小时的文件完成");
                        DebugCountAnHour.apiCountMap.clear();
                    }
                    String date = df.format(te);
                    System.out.println(date);
                    Date dd = null;
                    try {
                        dd = df.parse(date);
                    } catch (Exception e) {

                    }
                    dd.setMinutes(00);
                    dd.setSeconds(00);
                    DebugCountAnHour.setRecordTime(dd.getTime());
                    DebugCountAnHour.setApiCount(msg[3]);
                }
            }
        }
        if ("emergency".equals(msg[0])) {
            EmergencyData emergencyData= new EmergencyData();
            long te = (long)((Double.parseDouble(msg[1]))*1000);
            emergencyData.setEmerId(UUID.randomUUID().toString());
            emergencyData.setTimestamp(te);
            emergencyData.setApi(msg[2]);
            emergencyData.setStatus(Integer.parseInt(msg[3]));
            emergencyData.setMsg(msg[4]);
            emergencyDataService.addEmergencyData(emergencyData);
        }
        if("error".equals(msg[0])){
            ErrorData errorData = new ErrorData();
            long te = (long)((Double.parseDouble(msg[1]))*1000);
            errorData.setErrorId(UUID.randomUUID().toString());
            errorData.setTimestamp(te);
            errorData.setApi(msg[2]);
            errorData.setMsg(msg[3]);
            errorDataService.addErrorData(errorData);
        }
        if("info".equals(msg[0])){
            InfoData infoData = new InfoData();
            long te = (long)((Double.parseDouble(msg[1]))*1000);
            infoData.setInfoId(UUID.randomUUID().toString());
            infoData.setTimestamp(te);
            infoData.setMsg(msg[2]);
            infoDataService.addInfoData(infoData);
        }
    }
}
