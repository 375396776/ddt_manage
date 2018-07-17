package com.ddt.manage.commom;

import java.util.ResourceBundle;

public final class FMBankConstantsOfPayment {

	public final static String reqhttpurl = ResourceBundle.getBundle("p2p").getString("p2p.requrlhttp");
	public static final String Partner_Num = ResourceBundle.getBundle("p2p").getString("p2p.partnernum");// 商户号
	public static final String MD5_KEY = ResourceBundle.getBundle("p2p").getString("p2p.reqkey");// MD5加密key
	public static final String CHARSET = "utf-8";

	/**
	 * 标的业务
	 */
	// 发标
	public static final String BidsBusiness_issueBid = reqhttpurl + "/reagw/tender/rest.htm";
	/**
	 * 充提业务
	 */
	// 网银充值
	public static final String CP_ReCharge = reqhttpurl + "/reagw/service/deposit.htm";
	// 快捷充值签约
	public static final String CP_ReChargeSign = reqhttpurl + "/reagw/service/depwit.htm";
	// 快捷充值确认
	public static final String CP_ReChargeConfirm = reqhttpurl + "/reagw/service/depwit.htm";
	// 快捷充值重发短信
	public static final String CP_ReChargeResendMsg = reqhttpurl + "/reagw/service/depwit.htm";
	// 充值查询
	public static final String CP_ReChargeQuery = reqhttpurl + "/reagw/service/depwit.htm";
	// 提现
	public static final String CP_ReChargeWithdraw = reqhttpurl + "/reagw/service/withdraw.htm";
	// 提现查询
	public static final String CP_ReChargeWithdrawQuery = reqhttpurl + "/reagw/service/depwit.htm";
	// 企业分账
	public static final String CP_ReChargeBusinessAccounting = reqhttpurl + "/reagw/service/depwit.htm";
}
