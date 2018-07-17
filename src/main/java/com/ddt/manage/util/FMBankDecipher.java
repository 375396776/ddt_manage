package com.ddt.manage.util;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ddt.manage.commom.FMBankConstantsOfPayment;

public class FMBankDecipher {

	/**
	 * 解密1
	 * 
	 * @param merchant_id
	 * @param data
	 * @param encryptkey
	 * @return
	 * @throws com.reapal.common.exception.ServiceException
	 */
	public static String decryptData(String post) throws Exception {

		// 将返回的json串转换为map

		TreeMap<String, String> map = JSON.parseObject(post,
				new TypeReference<TreeMap<String, String>>() {
				});
		String encryptkey = map.get("encryptkey");
		String data = map.get("data");

		// 商户获取自己的私钥进行解密
		PrivateKey pvkformPfx = FMBankRSA.getPvkformPfx(FMBankUtil.privateKey,
				FMBankUtil.password);
		String key = FMBankRSA.decrypt(encryptkey, pvkformPfx);//解密得到key

		post = FMBankAES.decryptFromBase64(data, key);//用key对密文data进行解密操作得到业务响应数据明文

		return post;
	}

	/**
	 * 解密2
	 * 
	 * @param merchant_id
	 * @param data
	 * @param encryptkey
	 * @return
	 * @throws com.reapal.common.exception.ServiceException
	 */
	public static String decryptData(String encryptkey, String data)
			throws Exception {

		// 获取自己私钥解密
		PrivateKey pvkformPfx = FMBankRSA.getPvkformPfx(FMBankUtil.privateKey, FMBankUtil.password);
				
		String decryptKey = FMBankRSA.decrypt(encryptkey, pvkformPfx);

		return FMBankAES.decryptFromBase64(data, decryptKey);

	}
	

	/**
	 * 加密
	 * 
	 * @param merchant_id
	 * @param data
	 * @param encryptkey
	 * @return
	 * @throws com.reapal.common.exception.ServiceException
	 */
	public static Map<String, String> encryptData(String json){	
		try {	
			System.out.println("json数据============>" + json);
	
			// 商户获取银行的公钥
			PublicKey pubKeyFromCrt;
			
			pubKeyFromCrt = FMBankRSA.getPubKeyFromCRT(FMBankUtil.pubKeyUrl);//公钥存放路径
			
			// 随机生成16数字
			String key = getRandom(16);
	
			// 使用RSA算法将商户自己随机生成的AESkey加密
			String encryptKey = FMBankRSA.encrypt(key, pubKeyFromCrt);
			// 使用AES算法用随机生成的AESkey，对json串进行加密
			String encryData = FMBankAES.encryptToBase64(json, key);
	
			System.out.println("密文key============>" + encryptKey);
			System.out.println("密文数据============>" + encryData);
	
			Map<String, String> map = new HashMap<String, String>();
			//封装加密后请求接口参数
			map.put("encryptkey", encryptKey);
	        map.put("data", encryData);
	        map.put("merchant_id", FMBankConstantsOfPayment.Partner_Num);
	        return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		
	}

	public static Random random = new Random();

	public static String getRandom(int length) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < length; i++) {
			boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
			if (isChar) { // 字符串
				int choice = (random.nextInt(2) % 2 == 0) ? 65 : 97; // 取得大写字母还是小写字母
				ret.append((char) (choice + random.nextInt(26)));
			} else { // 数字
				ret.append(Integer.toString(random.nextInt(10)));
			}
		}
		return ret.toString();
	}
}