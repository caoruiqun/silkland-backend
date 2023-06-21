package com.caoruiqun.template.testmain;

import com.alibaba.fastjson2.JSONObject;
import com.caoruiqun.template.common.util.SignatureUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.caoruiqun.template.common.util.SignatureUtil.FIELD_SIGNATURE;
import static com.caoruiqun.template.common.util.SignatureUtil.generateSignature;

/**
 * @author caoruiqun
 * @date 2023/6/13 19:39
 * @desc:
 */
public class Base64Test {

    @Test
    public void test01() {

        Map<String,String> reqMap = new HashMap<>();
        reqMap.put("account", "admin");
        reqMap.put("tenantcode", "000");
        reqMap.put("appid", "x0000102");
        reqMap.put("timestamp", "1686634058248");
        reqMap.put("pagevalue", "");
        reqMap.put("otherargs", "{}");
        reqMap.put("signature", "4e147ec00f825c7eaff095c36ee9375f5aeba87d0ad1abda2c6f40c7e1de7ac4");

        String jsonStr = JSONObject.toJSONString(reqMap);

        try {
            Base64.Encoder encoder = Base64.getEncoder();
            String encoded = encoder.encodeToString(jsonStr.getBytes(StandardCharsets.UTF_8));
            System.out.println("encoded = " + encoded);

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decode = decoder.decode(encoded);
            String decoded = new String(decode, StandardCharsets.UTF_8);
            System.out.println("decoded = " + decoded);

            Map<String, String> request = JSONObject.parseObject(decoded, Map.class);
            System.out.println("request = " + request);

            Map<String, String> paramMap = new HashMap<>();
            for (Map.Entry<String, String> entry  : request.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                paramMap.put(key,value);
            }
//            paramMap.remove("signeddata");
            System.out.println("paramMap = " + paramMap);

            String sign = paramMap.get(FIELD_SIGNATURE);
            System.out.println("sign = " + sign);

            boolean reuslt = SignatureUtil.isSignatureValid(paramMap, "006.eyJ0aGlyZFBhcnR5TG9naW4iOiIxIiwiZXhwIjoxNjg4MTk1MTk2fQ.65jiuP4V8iAMwvf1NawFttqfSL_3FMZAxxTuWfrvSk0");
            if (!reuslt){
                System.out.println("signature 签名校验失败");
            }
            System.out.println("reuslt = " + reuslt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void test02() {
        Map<String,String> reqMap = new HashMap<>();
        reqMap.put("account", "admin");
        reqMap.put("tenantcode", "000");
        reqMap.put("appid", "x0000102");
        reqMap.put("timestamp", "1686634058248");
        reqMap.put("pagevalue", "");
        reqMap.put("otherargs", "{}");

        String appKey = "006.eyJ0aGlyZFBhcnR5TG9naW4iOiIxIiwiZXhwIjoxNjg4MTk1MTk2fQ.65jiuP4V8iAMwvf1NawFttqfSL_3FMZAxxTuWfrvSk0";
        String s = generateSignature(reqMap, appKey);
        System.out.println("s = " + s);

    }

    @Test
    public void test03() {
        Map<String,String> reqMap = new HashMap<>();
        reqMap.put("account", "admin");
        reqMap.put("tenantcode", "101");
        reqMap.put("appid", "x0000102");
        reqMap.put("timestamp", "1686634058248");
        reqMap.put("pagevalue", "");
        reqMap.put("otherargs", "{}");

        String appKey = "006.eyJ0aGlyZFBhcnR5TG9naW4iOiIxIiwiZXhwIjoxNjg4MTk1MTk2fQ.65jiuP4V8iAMwvf1NawFttqfSL_3FMZAxxTuWfrvSk0";
        String s = generateSignature(reqMap, appKey);
        System.out.println("s = " + s);

    }


    @Test
    public void test04() {

        Map<String,String> reqMap = new HashMap<>();
        reqMap.put("account", "admin");
        reqMap.put("tenantcode", "101");
        reqMap.put("appid", "x0000102");
        reqMap.put("timestamp", "1686634058248");
        reqMap.put("otherargs", "{123}");
        reqMap.put("signature", "1e59c5f185d7ae813204be4c813a95ccd9701de277feea80ccb9df86d91d1917");

        String jsonStr = JSONObject.toJSONString(reqMap);

        try {
            Base64.Encoder encoder = Base64.getEncoder();
            String encoded = encoder.encodeToString(jsonStr.getBytes(StandardCharsets.UTF_8));
            System.out.println("encoded = " + encoded);

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decode = decoder.decode(encoded);
            String decoded = new String(decode, StandardCharsets.UTF_8);
            System.out.println("decoded = " + decoded);

            Map<String, String> request = JSONObject.parseObject(decoded, Map.class);
            System.out.println("request = " + request);

            Map<String, String> paramMap = new HashMap<>();
            for (Map.Entry<String, String> entry  : request.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                paramMap.put(key,value);
            }
//            paramMap.remove("signeddata");
            System.out.println("paramMap = " + paramMap);

            String sign = paramMap.get(FIELD_SIGNATURE);
            System.out.println("sign = " + sign);

            boolean reuslt = SignatureUtil.isSignatureValid(paramMap, "006.eyJ0aGlyZFBhcnR5TG9naW4iOiIxIiwiZXhwIjoxNjg4MTk1MTk2fQ.65jiuP4V8iAMwvf1NawFttqfSL_3FMZAxxTuWfrvSk0");
            if (!reuslt){
                System.out.println("signature 签名校验失败");
            }
            System.out.println("reuslt = " + reuslt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
