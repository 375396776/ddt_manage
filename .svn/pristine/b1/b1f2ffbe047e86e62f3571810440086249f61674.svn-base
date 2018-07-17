package com.ddt.manage.service;

import java.util.Map;

import com.ddt.manage.po.FMBankReCharge;

/**
 * 
 * @Title: FMBankChargeProvidedService
 * @Description: 充提业务
 * @Company: 
 * @author 李斌
 * @date 2017年11月29日 下午2:30:42 
 * @version 1.0
 */
public interface FMBankChargeProvidedService
{

    /**网银充值
     * @param recharge
     * @return
     */
	Map<String, String> reCharge(FMBankReCharge fmBankrecharge);

    /**快捷充值签约
     * @param recharge
     * @return
     */
	FMBankReCharge reChargeSign(FMBankReCharge fmBankrecharge);

    /**快捷充值确认
     * @param recharge
     * @return
     */
	FMBankReCharge reChargeConfirm(FMBankReCharge fmBankrecharge);

    /**快捷充值重发短信
     * @param recharge
     * @return
     */
	FMBankReCharge reChargeResendMsg(FMBankReCharge fmBankrecharge);

    /**充值查询
     * @param recharge
     * @return
     */
	FMBankReCharge reChargeQuery(FMBankReCharge fmBankrecharge);

    /**提现
     * @param recharge
     * @return
     */
    String reChargeWithdraw(FMBankReCharge fmBankrecharge);
    /**一键提现
     * @param recharge
     * @return
     */
    FMBankReCharge oneKeyWithdraw(FMBankReCharge fmBankrecharge);
    /**自动提现
     * @param recharge
     * @return
     */
    FMBankReCharge reChargeAutoWithdraw(FMBankReCharge fmBankrecharge);

    /**提现查询
     * @param recharge
     * @return
     */
    FMBankReCharge reChargeWithdrawQuery(FMBankReCharge fmBankrecharge);

    /**企业分账
     * @param recharge
     * @return
     */
    FMBankReCharge reChargeBusinessAccounting(FMBankReCharge fmBankrecharge);

    /**
     * 获得签名 请求字符串
     * @param recharge
     * @return
     */
    String getSignReqDate(FMBankReCharge fmBankrecharge);

}
