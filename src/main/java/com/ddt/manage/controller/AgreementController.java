package com.ddt.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddt.manage.util.FMBankDecipher;
import com.google.gson.JsonParser;

/**
 * 
 * @author reapal.cs 签约demo
 *
 */
@Controller
@RequestMapping("/fmcallback")
public class AgreementController {

	/**
	 * 同步通知接收地址 结果解析跳转商户站点
	 * 
	 * @return
	 */
	@RequestMapping("/returnRechargeAction")
	public String synchronizedCallback(HttpServletRequest request, String merchant_id, String data, String encryptkey,
			HttpServletResponse response, Model model) {

		// 对响应密文进行解密
		String responseData;
		JsonParser jp = new JsonParser();
		try {
			responseData = FMBankDecipher.decryptData(encryptkey, data);

//			System.out.println(responseData + "--------------------------------------");
			// 商户业务处理逻辑。。。。
			if (responseData.indexOf("resError") != -1) {// 异常返回
				// JSONObject parseObject = JSON.parseObject(responseData);
				jp.parse(responseData).getAsJsonObject();
				model.addAttribute("result", responseData);

			} else {// 正常返回
				// String resData = BaseDemo.getResDataFromResult(responseData);
				String[] result = responseData.split("&");
				String resDataStr = result[result.length - 1];
				String resData = resDataStr.substring(resDataStr.indexOf("=") + 1);
//				System.out.println(resData);
				model.addAttribute("result", resData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/front/pc/result";
	}

	/**
	 * 异步通知接收地址（需要映射外网地址） 结果直接写入HTTP response body
	 * 
	 * @return
	 */
	@RequestMapping("/notifyRechargeAction")
	@ResponseBody
	public String asynCallback(String data, String encryptkey, Model model) {
		// System.out.println(version);
		// System.out.println("返回的resData------"+resData+"------version-------"+version+"--------service-------"+service);
		// System.out.println("返回的sign-------"+sign+"--------signType------"+signType+"-------partner-------"+partner);
		// System.out.println("返回的sign-------"+resError+"--------model------"+model);
		// Map<String, String[]> parameterMap = request.getParameterMap();
		// System.out.println("返回的map-------"+parameterMap);
		// if (resData != null && !"".equals(resData)) {// 正常返回结果以 resData返回
		// // 商户业务逻辑 保存订单 更新订单状态等。
		//
		// } else if (resError != null && !"".equals(resError)) {// 异常返回
		// 是resError
		// // 异常处理逻辑
		// }

		// 对响应密文进行解密
		String responseData;
		JsonParser jp = new JsonParser();
		try {
			responseData = FMBankDecipher.decryptData(encryptkey, data);

			System.out.println(responseData + "--------------------------------------");
			// 商户业务处理逻辑。。。。
			if (responseData.indexOf("resError") != -1) {// 异常返回
				// JSONObject parseObject = JSON.parseObject(responseData);
				jp.parse(responseData).getAsJsonObject();
				model.addAttribute("result", responseData);

			} else {// 正常返回
				// String resData = BaseDemo.getResDataFromResult(responseData);
				String[] result = responseData.split("&");
				String resDataStr = result[result.length - 1];
				String resData = resDataStr.substring(resDataStr.indexOf("=") + 1);
				System.out.println(resData);
				model.addAttribute("result", resData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String str = "{\"returnCode\":\"0000\",\"returnMsg\":\"接收成功\"}";
		return str;
	}
}
