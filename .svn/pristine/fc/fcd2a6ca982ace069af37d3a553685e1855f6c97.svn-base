package com.ddt.manage.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ddt.manage.commom.FMBankFormsConstants;
import com.ddt.manage.po.FMBankReCharge;
import com.ddt.manage.service.FMBankChargeProvidedServiceImpl;
import com.ddt.manage.util.DateUtil;
import com.ddt.manage.util.GetMac;

@Controller
@RequestMapping("/test")
public class ChargeProviderController {

	@Autowired
	FMBankChargeProvidedServiceImpl fmBankChargeProvidedServiceImpl;
	/**
	 * 
	 * @Title:reChargeResendMsgController 
	 * @Description: 网银充值
	 * @author lb
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/reCharge")
	public ModelAndView reChargeController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FMBankReCharge fmBankReCharge = new FMBankReCharge();
		fmBankReCharge.setOrderNo("libin-"+DateUtil.Formmat_yyyy_MM_dd__HH_mm_ss(new Date()));
		fmBankReCharge.setContracts("RB17120695GED1HM");
		fmBankReCharge.setAmount(200.22);
		fmBankReCharge.setCharge(1.23);
		fmBankReCharge.setChannel("bank");
		fmBankReCharge.setPayCustomerNo("");
		fmBankReCharge.setBusway("00");
		fmBankReCharge.setReturnUrl(FMBankFormsConstants.RECHARGE_ACTION_RETURNURL);
		fmBankReCharge.setNotifyUrl(FMBankFormsConstants.RECHARGE_ACTION_NOTIFYURL);
		fmBankReCharge.setRemark("remark");
		String ApplyTime = DateUtil.Formmat_yyyy_MM_dd__HH_mm_ss(new Date());
		fmBankReCharge.setApplyTime(ApplyTime);
		Map<String, String> reCharge = fmBankChargeProvidedServiceImpl.reCharge(fmBankReCharge);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("/front/pc/fmbank_form");
		mv.addObject("root",reCharge);
		mv.addObject("action",FMBankFormsConstants.RECHARGE_ACTION);
		return mv;
	}
	/**
	 * 
	 * @Title:rechargeContractController 
	 * @Description: 快捷充值签约
	 * @author lb
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/rechargeContract")
	public Object rechargeContractController(HttpServletRequest request, HttpServletResponse response) {
		FMBankReCharge fmBankReCharge = new FMBankReCharge();
		fmBankReCharge.setOrderNo("libin0000000000001");
		fmBankReCharge.setContracts("RB1711294NV4C5C3");
		fmBankReCharge.setBankCard("1121122112");
		fmBankReCharge.setUserName("郑光伟");
		fmBankReCharge.setCertType("01");
		fmBankReCharge.setUserIdentity("220182199004200037");
		fmBankReCharge.setUserMobile("15567080819");
		fmBankReCharge.setCurrency("cny");
		fmBankReCharge.setAmount(100.00);
		fmBankReCharge.setCharge(0.00);
		fmBankReCharge.setBusway("00");
		fmBankReCharge.setTerminalInfo("22222");
		fmBankReCharge.setMemberIp("2222");
		fmBankReCharge.setNotifyUrl("http://localhost/ddt_manage/agreement/synchronizedCallback.do");
		fmBankReCharge.setRemark("remark");
		String ApplyTime = DateUtil.Formmat_yyyy_MM_dd__HH_mm_ss(new Date());
		fmBankReCharge.setApplyTime(ApplyTime);
//		FMBankChargeProvidedServiceImpl fmBankChargeProvidedServiceImpl = new FMBankChargeProvidedServiceImpl();
		FMBankReCharge reChargeSign = fmBankChargeProvidedServiceImpl.reChargeSign(fmBankReCharge);
		return reChargeSign;
	}
	/**
	 * 快捷充值确认
	 * @Title:rechargeConfirmController 
	 * @Description: TODO
	 * @author lb
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/rechargeConfirm")
	public Object rechargeConfirmController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FMBankReCharge fmBankReCharge = new FMBankReCharge();
		fmBankReCharge.setOrderNo("libin0000000000001");
		fmBankReCharge.setContracts("RB1711294NV4C5C3");
		fmBankReCharge.setCheckCode("123456");
		fmBankReCharge.setBusway("00");
		String mac = GetMac.getMac();
		fmBankReCharge.setTerminalInfo(mac);
		String memberIp = request.getRemoteAddr();
		fmBankReCharge.setMemberIp(memberIp);
		fmBankReCharge.setRemark("remark");
		String ApplyTime = DateUtil.Formmat_yyyy_MM_dd__HH_mm_ss(new Date());
		fmBankReCharge.setApplyTime(ApplyTime);
//		FMBankChargeProvidedServiceImpl fmBankChargeProvidedServiceImpl = new FMBankChargeProvidedServiceImpl();
		FMBankReCharge reChargeSign = fmBankChargeProvidedServiceImpl.reChargeConfirm(fmBankReCharge);
		return reChargeSign;
	}
	/**
	 * 快捷充值重发短信
	 * @Title:reChargeResendMsgController 
	 * @Description: TODO
	 * @author lb
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/reChargeResendMsg")
	public Object reChargeResendMsgController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FMBankReCharge fmBankReCharge = new FMBankReCharge();
		fmBankReCharge.setOrderNo("libin0000000000001");
		fmBankReCharge.setContracts("RB1711294NV4C5C3");
		fmBankReCharge.setBusway("00");
		String mac = GetMac.getMac();
		fmBankReCharge.setTerminalInfo(mac);
		String memberIp = request.getRemoteAddr();
		fmBankReCharge.setMemberIp(memberIp);
		fmBankReCharge.setRemark("remark");
		String ApplyTime = DateUtil.Formmat_yyyy_MM_dd__HH_mm_ss(new Date());
		fmBankReCharge.setApplyTime(ApplyTime);
//		FMBankChargeProvidedServiceImpl fmBankChargeProvidedServiceImpl = new FMBankChargeProvidedServiceImpl();
		FMBankReCharge reChargeSign = fmBankChargeProvidedServiceImpl.reChargeResendMsg(fmBankReCharge);
		return reChargeSign;
	}
	@RequestMapping(value = "/reChargeQuery")
	public Object reChargeQueryController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FMBankReCharge fmBankReCharge = new FMBankReCharge();
		fmBankReCharge.setOrderNo("libin-2017-12-08 14:48:35");
		fmBankReCharge.setQueryTime("2017-12-08 14:48:35");//reapal.trust.depositQuery
		FMBankReCharge reChargeSign = fmBankChargeProvidedServiceImpl.reChargeQuery(fmBankReCharge);
		return reChargeSign;
	}
}
