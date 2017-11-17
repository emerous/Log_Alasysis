package com.fx.la.parselog;

public class ParseLogsFactory {

    public static ParseLogs getError(){
        return new ProcessErrorLogs();
    }
    public static ParseLogs getDebug(){
        return  new ProcessDebugLogs();
    }
    public static ParseLogs getEmergency(){
        return new ProcessEmergencyLogs();
    }
    public static ParseLogs getInfo(){
        return new ProcessInfoLogs();
    }
}
