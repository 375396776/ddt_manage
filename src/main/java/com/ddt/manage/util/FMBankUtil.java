package com.ddt.manage.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.ddt.manage.util.MD5Utils;
import com.ddt.manage.commom.FMBankConstantsOfPayment;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 富民银行工具类
 * 
 * @author zongwei
 *
 */
public class FMBankUtil {
	
	protected static Logger log = Logger.getLogger("FMBankUtil");
	
	//银行公钥存放路径  商户替换成自己的服务器存放路径
	public static String pubKeyUrl = "D:\\cert\\itrus001.cer";
	// 商户自己的私钥存放路径
	public static String privateKey = "D:\\cert\\itrus001.pfx";
	// 私钥密码
	public static String password = "123456";
	
	/**
	 * 请求接口 返回数据
	 * @param service 接口名称
	 * @param reqData 业务json
	 * @param url	     请求地址
	 * @return
	 */
	public static String getBankData(String service, String reqData, String url){
		// 封装请求参数
		Map<String,String> map = bulidMap(service, reqData);
		map.put("url", url);
		// 请求接口得到响应报文
		String responseStr = "";
		try {
			responseStr = FMBankHttpClientUtil.post(map);
		} catch (Exception e) {
			log.info("请求接口名称：" + service + "，post请求接口异常，异常信息：" + responseStr);
			e.printStackTrace();
		}
		log.info("请求接口名称：" + service + "，得到响应加密报文：" + responseStr);
		if(StringUtil.isEmpty(responseStr)){
			return "";
		}
		// 解密响应报文
		String resStr = getResponseData(reqData, responseStr);
		log.info("请求接口名称：" + service + "，解密响应报文：" + resStr);
		return resStr;
	}
	/**
	 * 构建参数map
	 * @param url
	 * @param service
	 * @param sign
	 * @param reqData
	 * @return
	 */
	public static Map<String,String> bulidMap(String service, String reqData){
		// 签名sign
		String sign = "";
		try {
			sign = MD5Utils.sign(reqData, FMBankConstantsOfPayment.MD5_KEY, FMBankConstantsOfPayment.CHARSET);
		} catch (Exception e) {
			log.info("生成签名sign异常，异常信息：" + e.getMessage());
			e.printStackTrace();
		}
		log.info("生成签名sign：" + sign);
		Map<String,String> map = new HashMap<String,String>();
		map.put("version", "1.0");
		map.put("partner", FMBankConstantsOfPayment.Partner_Num);
		map.put("signType", "0");
		map.put("service", service);
		map.put("sign", sign);
		map.put("reqData", reqData);
		// 将map转化为json串用于加密
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		//对请求参数加密
		Map<String, String> requestMaps = FMBankDecipher.encryptData(jsonStr);
		return requestMaps;
	}
	
	/**
	 * 解析接口返回的加密串
	 * @param objStr 业务对象json
	 * @param responseStr 接口返回加密串
	 * @return
	 * @throws Exception
	 */
	public static String getResponseData(String objStr, String responseStr){
		String decryptStr = "";
		try {
			decryptStr = FMBankDecipher.decryptData(responseStr);
		} catch (Exception e) {
			log.info("解密响应报文异常，异常信息：" + e.getMessage());
			e.printStackTrace();
		}
		if(StringUtil.isEmpty(decryptStr)){
			return "";
		}
		if(decryptStr.indexOf("&")!=-1){
			decryptStr = getResDataFromResult(decryptStr);
		}
		String res = objStr.substring(0, objStr.length()-1) + "," + decryptStr.substring(1);
        return res;
	}
	
	/**
	 * json字符串转json对象
	 * @param resData
	 * @return
	 */
	public static JsonObject bulidResDataObject(String resData){
		JsonParser jp = new JsonParser();
		JsonObject jo = jp.parse(resData).getAsJsonObject();
		return jo;
	}
	
	/**
	 * json字符串转对象
	 * @param resData
	 * @return 
	 * @return
	 */
	public static <T> T bulidResDataJavaObject(String resData, Class<T> c){
		Gson gs = new Gson();
		T t = (T) gs.fromJson(resData, c);
		return t;
	}
	
	/**
	 * 根据接口返回获取resData
	 * @param responseStr
	 * @return
	 */
	public static String getResDataFromResult(String responseStr){
		String[] result = responseStr.split("&");
		String resDataStr = result[result.length-1];
		String resData = resDataStr.substring(resDataStr.indexOf("=")+1);
		return resData;
	}
}