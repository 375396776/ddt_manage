package com.ddt.manage.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 
 * @author reapal.cs
 *
 */
public class FMBankHttpClientUtil {
	

	public static String post( Map<String,String> map ) throws Exception{
		String result = null;
		String url = map.get("url");
		
		HttpClient httpClient = new HttpClient();
		PostMethod method = new PostMethod(url);
		
		
		addParameter(method, map);
		
		
		//自定义的重发策略，不重发
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
            new DefaultHttpMethodRetryHandler(0, false));
        
        //发送http请求
        httpClient.executeMethod(method);
		
        //读取请求报文
        BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
        StringBuffer sb = new StringBuffer();
        String str = "";
        while( (str = br.readLine()) != null){
        	sb.append(str);
        }
        result = sb.toString();
		
		
		return result;
	}
	
	private static void addParameter(PostMethod httpPost, Map<String,String> map) {
        httpPost.setRequestHeader("contentType", "text/html; charset=utf-8");
        httpPost.setRequestHeader("pageEncoding", "utf-8");

        //设置请求和返回charset
        httpPost.getParams().setContentCharset("utf-8");

        httpPost.addParameter("merchant_id", map.get("merchant_id"));
        httpPost.addParameter("data", map.get("data"));
        httpPost.addParameter("encryptkey", map.get("encryptkey"));
    }
    
	
}
