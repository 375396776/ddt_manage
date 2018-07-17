/*
 *	History				Who				What
 *  2014-10-31			liuhongmei			Created.
 */
package com.ddt.manage.util;

/**
 *
 * @version 1.0
 */
public class StringUtil {
	/**
	 * @param _str
	 *            if <code>null</code> or empty string return an array with zero
	 *            length.
	 * @param _sDelim
	 *            if <code>null</code> or empty string then this will set to
	 *            <code>,</code>
	 * @return
	 */
	public static int[] splitToInt(String _str, String _sDelim) {
		// 如果是空串,返回长度为0的数组
		if (isEmpty(_str)) {
			return new int[0];
		}

		// to avoid null pointer exception throw
		if (isEmpty(_sDelim)) {
			_sDelim = ",";
		}

		java.util.StringTokenizer stTemp = new java.util.StringTokenizer(_str,
				_sDelim);
		int[] arInt = new int[stTemp.countTokens()];
		int nIndex = 0;
		String sValue;
		while (stTemp.hasMoreElements()) {
			sValue = (String) stTemp.nextElement();
			arInt[nIndex] = Integer.parseInt(sValue.trim());
			nIndex++;
		}
		return arInt;
	}

	public static boolean isEmpty(String _string) {
		return ((_string == null) || (_string.trim().length() == 0));
	}
	
	/** 
	 * @Description:把数组转换为一个用逗号分隔的字符串 ，以便于用in+String 查询 
	 */  
	public static String converToString(Integer[] ig) {  
	    String str = "";  
	    if (ig != null && ig.length > 0) {  
	        for (int i = 0; i < ig.length; i++) {  
	            str += ig[i] + ",";  
	        }  
	    }  
	    str = str.substring(0, str.length() - 1);  
	    return str;  
	} 
	
	/**
	 * 判断一个字符串在另一个字符串里的个数
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int countStr(String str1, String str2) {
		int counter = 0;
		if (str1.indexOf(str2) == -1) {
			return 0;
		}
		while (str1.indexOf(str2) != -1) {
			counter++;
			str1 = str1.substring(str1.indexOf(str2) + str2.length());
		}
		return counter;
	} 
}
