package com.caoruiqun.template.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author caoruiqun
 * @date 2023/6/13 17:24
 * @desc:
 */
public class SignatureUtil {

    public static final String FIELD_SIGNATURE = "signature";

    /**
     * 判断签名是否正确，必须包含sign字段，否则返回false。
     * @param data Map类型数据
     * @param key  API密钥
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean isSignatureValid(Map<String, String> data, String key){
        if (!data.containsKey(FIELD_SIGNATURE)) {
            return false;
        }
        String sign = data.get(FIELD_SIGNATURE);
        System.out.println("sign = " + sign);
        return generateSignature(data, key).equals(sign);
    }


    /**
     * 生成签名（SHA256）
     *
     * @param data   待签名数据
     * @param appKey API密钥
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String appKey) {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (FIELD_SIGNATURE.equals(k)) {
                continue;
            }
            if (data.get(k) instanceof String) {
                // 参数值为空，则不参与签名
                if (data.get(k).trim().length() > 0) {
                    sb.append(k).append("=").append(data.get(k).trim()).append("&");
                }
            }


        }
        sb.append("key=").append(appKey);
        return getSHA256(sb.toString());
    }

    /**
     * 利用java原生的类实现SHA256加密
     *
     * @param str 参数拼接的字符串
     * @return
     */
    public static String getSHA256(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String temp = null;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                sb.append("0");
            }
            sb.append(temp);
        }
        return sb.toString();
    }

}
