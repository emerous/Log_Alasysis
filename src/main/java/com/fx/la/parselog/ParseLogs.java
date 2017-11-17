package com.fx.la.parselog;

public abstract class ParseLogs {
    /**
     * 返回对应流程步骤，并附上状态信息：1 正常，2 用户行为异常而中断 3 错误
     */
    public abstract String match(String path,String msg);

    /**
     * 匹配接口
     */
    public static String matchAPI(String path){
        String local = path.split(":")[1].trim();
        String step="";
        if ("/Lotto/userLottoLeftChance".equals(local)) {
            step="L_ULLC";
        }else if("/Kcode/kcodeAllGoods".equals(local)){
            step = "K_KAG";
        }else if("/Lotto/lotto".equals(local)){
            step= "L_L";
        }else if("/UserRewardsLog/rewardsRecords".equals(local)){
            step="URL_RR";
        }else if("/UserRewardsLog/rewardDetial".equals(local)){
            step="URL_RD";
        }else if("/UseKcodeReward/userUseKcodeRewardStatistic".equals(local)){
            step = "UKR_UKRS";
        }else if("/Kcode/kcodeGoodsGrants".equals(local)){
            step="K_KGG";
        }else if("/Scores/TotalScores".equals(local)||"/Scores/totalScores".equals(local)){
            step="S_TS";
        }else if("/Module/moduleInfo".equals(local)){
            step="M_MI";
        }else if("/Check/checkIn".equals(local)){
            step="C_CI";
        }else if("/Kcode/kcodeVerification".equals(local)){
            step="K_KV";
        }else if("/Kcode/phoneVerificationCode".equals(local)){
            step = "K_PVC";
        }else if("/Kcode/currentKcodeCheckStatus".equals(local)){
            step = "K_CKCS";
        }else if("/UserRewardsLog/fadeExpiredReward".equals(local)){
            step = "URL_FER";
        }
        return  step;
    }
}
