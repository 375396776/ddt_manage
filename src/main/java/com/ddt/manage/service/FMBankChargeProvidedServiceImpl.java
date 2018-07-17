package com.ddt.manage.service;

import java.lang.reflect.Type;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ddt.manage.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ddt.manage.commom.FMBankConstantsOfPayment;
import com.ddt.manage.po.FMBankReCharge;

/**
 * 充提业务
 * 
 * @author lizs
 *
 */
@Service("fmBankchargeProvidedService")
public class FMBankChargeProvidedServiceImpl implements FMBankChargeProvidedService {

	protected Logger log = Logger.getLogger(this.getClass());

	@Override
	public Map<String, String> reCharge(FMBankReCharge fmBankrecharge) {
		Gson gson = new Gson();
		String reqData = gson.toJson(fmBankrecharge);
		String service = "reapal.trust.depositApply";
		Map<String, String> map = FMBankUtil.bulidMap(service, reqData);
		return map;
	}

	@Override
	public FMBankReCharge reChargeSign(FMBankReCharge fmBankrecharge) {
		// bean转json得到reqData
		Gson gson = new Gson();
		String reqData = gson.toJson(fmBankrecharge);
		String service = "reapal.trust.depositApplyAPI";
		String resStr = FMBankUtil.getBankData(service, reqData, FMBankConstantsOfPayment.CP_ReChargeSign);
		if (StringUtil.isEmpty(resStr)) {
			return null;
		}
		// 包含返回结果的明文json 转 对象
		Type type = new TypeToken<FMBankReCharge>() {
		}.getType();
		FMBankReCharge result = JSON.parseObject(resStr, type);
		return result;
	}

	@Override
	public FMBankReCharge reChargeConfirm(FMBankReCharge fmBankrecharge) {
		// bean转json得到reqData
		Gson gson = new Gson();
		String reqData = gson.toJson(fmBankrecharge);
		String service = "reapal.trust.depositConfirmAPI";
		String resStr = FMBankUtil.getBankData(service, reqData, FMBankConstantsOfPayment.CP_ReChargeConfirm);
		if (StringUtil.isEmpty(resStr)) {
			return null;
		}
		// 包含返回结果的明文json 转 对象
		Type type = new TypeToken<FMBankReCharge>() {
		}.getType();
		FMBankReCharge result = JSON.parseObject(resStr, type);
		return result;
	}

	@Override
	public FMBankReCharge reChargeResendMsg(FMBankReCharge fmBankrecharge) {
		// bean转json得到reqData
		Gson gson = new Gson();
		String reqData = gson.toJson(fmBankrecharge);
		String service = "reapal.trust.depositQuery";
		String resStr = FMBankUtil.getBankData(service, reqData, FMBankConstantsOfPayment.CP_ReChargeResendMsg);
		if (StringUtil.isEmpty(resStr)) {
			return null;
		}
		// 包含返回结果的明文json 转 对象
		Type type = new TypeToken<FMBankReCharge>() {
		}.getType();
		FMBankReCharge result = JSON.parseObject(resStr, type);
		return result;
	}

	@Override
	public FMBankReCharge reChargeQuery(FMBankReCharge fmBankrecharge) {
		// bean转json得到reqData
		Gson gson = new Gson();
		String reqData = gson.toJson(fmBankrecharge);
		String service = "reapal.trust.depositQuery";
		String resStr = FMBankUtil.getBankData(service, reqData, FMBankConstantsOfPayment.CP_ReChargeResendMsg);
		if (StringUtil.isEmpty(resStr)) {
			return null;
		}
		// 包含返回结果的明文json 转 对象
		Type type = new TypeToken<FMBankReCharge>() {
		}.getType();
		FMBankReCharge result = JSON.parseObject(resStr, type);
		return result;
	}

	@Override
	public String reChargeWithdraw(FMBankReCharge fmBankrecharge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FMBankReCharge oneKeyWithdraw(FMBankReCharge fmBankrecharge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FMBankReCharge reChargeAutoWithdraw(FMBankReCharge fmBankrecharge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FMBankReCharge reChargeWithdrawQuery(FMBankReCharge fmBankrecharge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FMBankReCharge reChargeBusinessAccounting(FMBankReCharge fmBankrecharge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSignReqDate(FMBankReCharge fmBankrecharge) {
		// TODO Auto-generated method stub
		return null;
	}

}
