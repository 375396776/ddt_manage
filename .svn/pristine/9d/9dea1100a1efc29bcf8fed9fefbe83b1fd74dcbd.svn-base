package com.ddt.manage.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class MD5Utils
{
    private static Logger log = Logger.getLogger(MD5Utils.class);

    public static String sign(String content, String key, String charset) throws Exception
    {
        String signData = content + key;
        try
        {

            String sign = DigestUtils.md5Hex(signData.getBytes(charset));
            log.info("MD5签名[content = " + content + "; charset = " + charset + "]结果：" + sign);
            return sign;
        }
        catch (UnsupportedEncodingException e)
        {
            log.error("MD5签名[content = " + content + "; charset = " + charset + "]时发生异常！", e);
            throw new Exception(e);
        }
    }

    public static String signNoException(String content, String key, String charset)
    {
        String signData = content + key;

        String sign = null;
        try
        {
            sign = DigestUtils.md5Hex(signData.getBytes(charset));
            log.info("MD5签名[content = " + content + "; charset = " + charset + "]结果：" + sign);
        }
        catch (Exception e)
        {
            log.error("MD5签名[content = " + content + "; charset = " + charset + "]时发生异常！", e);
        }
        return sign;
    }

    public static void main(String[] args)
    {
        System.out.println(DigestUtils.md5Hex("1"));
    }

}
