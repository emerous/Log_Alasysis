package com.fx.la.controller;

import com.fx.la.entity.statistic.APITransferAmount;
import com.fx.la.entity.statistic.CommonApiMsg;
import com.fx.la.entity.statistic.EmerCountByStatus;
import com.fx.la.entity.statistic.EmerCountChangeWithTime;
import com.fx.la.mapper.EmergencyMapper;
import com.fx.la.service.BaseInfoService;
import com.fx.la.service.EmergencyDataService;
import com.fx.la.service.ErrorDataService;
import com.fx.la.service.InfoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/sc")
public class StatisticController {

    @Autowired
    BaseInfoService baseInfoService;
    @Autowired
    EmergencyDataService emergencyDataService;
    @Autowired
    ErrorDataService errorDataService;
    @Autowired
    InfoDataService infoDataService;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 接口按照如下顺序进行显示
     * L_ULLC       用户剩余抽奖机会
     * K_KAG        k码特权商品
     * L_L          抽奖
     * URL_RR
     * URL_RD
     * URL_FER
     * UKR_UKRS
     * K_KV
     * K_PVS
     * K_CKCS
     * K_KGG
     * S_TS
     * M_MI
     * C_CI
     */
    @RequestMapping(value = "/apiTransfer")
    @ResponseBody
    public APITransferAmount apiTransfer(@RequestParam("date") String date_start,
                                         @RequestParam("size") String date_end) {
        long start=0;
        long end=0;
        try{
            start = df.parse(date_start).getTime();
            end = df.parse(date_end).getTime();
        }catch (Exception e){

        }
        List<CommonApiMsg> base = baseInfoService.getCountByTimeRange(start, end);
        List<CommonApiMsg> emer = emergencyDataService.getCountByTimeRange(start, end);
        APITransferAmount ata = new APITransferAmount(14);
        CommonApiMsg cam;
        for (int i = 0; i < base.size(); i++) {
            cam = base.get(i);
            String api = cam.getApi();
            int val = cam.getCount();
            if (api.contains("|1")) {
                if (val > 100000) {
                    val = val / 20;
                }
                ata.setVal("normal", api, val);
            } else {
                ata.setVal("userMistake", api, val);
            }
        }
        for (int j = 0; j < emer.size(); j++) {
            cam = emer.get(j);
            String api = cam.getApi();
            int val = cam.getCount();
            ata.setVal("programError", api, val);
        }
        return ata;
    }
    @RequestMapping("/emerChangeWithTime")
    public EmerCountChangeWithTime emerChageWithTime(@RequestParam("date") String date_start,
                                                     @RequestParam("size") String date_end){
        long hour = 60 * 60 * 1000;
        long start=0;
        long end=0;
        try{
            start = df.parse(date_start).getTime();
            end = df.parse(date_end).getTime();
        }catch (Exception e){

        }
        long temp = end - start;
        long freq = temp / hour;
        int flag = (int) freq / 12;//查询都分成12份，flag为查询间隔时间（小时）
        EmerCountChangeWithTime eccwt = new EmerCountChangeWithTime(14,12);
        CommonApiMsg cam;
        for (int k = 0; k < 12; k++) {
            List<CommonApiMsg> emerByTime = emergencyDataService.getCountByTimeRange(start + k * flag * hour, start + (k + 1) * flag * hour);
            for (int l = 0; l < emerByTime.size(); l++) {
                cam = emerByTime.get(l);
                String api = cam.getApi();
                int val = cam.getCount();
                eccwt.setVal(api, val, k);
            }
        }
        return eccwt;
    }
    @RequestMapping("/emerCountByStatus")
    public EmerCountByStatus emerCountByStatus(@RequestParam("date") String date_start,
                                               @RequestParam("size") String date_end){
        long start=0;
        long end=0;
        try{
            start = df.parse(date_start).getTime();
            end = df.parse(date_end).getTime();
        }catch (Exception e){

        }
        List<CommonApiMsg> cam=emergencyDataService.getCountByStatus(start,end);
        int n = cam.size();
        EmerCountByStatus ecbs = new EmerCountByStatus(9);
        for(int i=0;i<n;i++){
            ecbs.setVal(Integer.parseInt(cam.get(i).getApi()),cam.get(i).getCount());
        }
        return ecbs;
    }
}
