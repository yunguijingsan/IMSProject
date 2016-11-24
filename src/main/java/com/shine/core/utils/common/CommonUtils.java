package com.shine.core.utils.common;

import java.io.Serializable;
import java.text.Format;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * 通用工具类
 *
 */
@Deprecated
public class CommonUtils {
    public static String lpad(Serializable id,int length) {
        String f = "%0" + length + "d";
        return String.format(f, id);
    }
    public static String randomNumberStr(int length){
        int randomCode = (int)(Math.random()*Math.pow(10, length));
        return lpad(randomCode,length);
    }
    /**
     * 生成六位随机验证码
     * @Description: TODO
     * @return
     * @return int
     */
    public static String createCheckCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }

    /**
     * 生成8位随机验证码
     * @Description: TODO
     * @return
     * @return int
     */
    public static String generateNumber() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 10000000));
    }

    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isBlank(Object arr[]) {
        return arr == null || arr.length == 0;
    }

    public static boolean isBlank(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(Object obj) {
        return null == obj;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isBlank(Collection col) {
        return col == null || col.isEmpty();
    }

    /**
     * 判断数组是否包含某个元素
     * @param array 数组
     * @param o 元素
     * @return
     */
    public static boolean arrayContains(Object[] array, Object o) {
        if (array != null) {
            for (Object arr : array) {
                if (arr instanceof String || arr instanceof Integer || arr instanceof Long || arr instanceof Double ||
                    arr instanceof Float || arr instanceof Byte) {
                    if (arr.equals(o)) {
                        return true;
                    }
                } else {
                    if (arr == o) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 返回某个元素在数组中的索引，不存在则返回-1
     * @param array 数组
     * @param o 元素
     * @return
     */
    public static int arrayIndex(Object[] array, Object o) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] instanceof String || array[i] instanceof Integer || array[i] instanceof Long ||
                    array[i] instanceof Double || array[i] instanceof Float || array[i] instanceof Byte) {
                    if (array[i].equals(o)) {
                        return i;
                    }
                } else {
                    if (array[i] == o) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     *  得到请求上下文地址（域名+上下文）
     * @param request
     * @return
     */
    public static String getRequestConetxtUrl() {
        HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer url = request.getRequestURL();
        String tempContextUrl =
            url.delete(url.length() - request.getRequestURI().length(),
                       url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        return tempContextUrl;
    }

    /**
     *判断验证码是否过期
     * @param date
     * @return
     */
    public static boolean ischekCodeDateOut(Date date) {
        return date.before(new Date(System.currentTimeMillis() - 30 * 60 * 1000));
    }

    /**
     *判断是否请求时间在规定时间以外   90秒
     * @param date
     * @return
     */
    public static boolean ischekCodeRequestDate(Date date) {
        return date.after(new Date(System.currentTimeMillis() - 90 * 1000));
    }

 
    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("^1[34578][0-9]{9}$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {
        params = CommonUtils.paraFilter(params);
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }
    /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }
    
    @SuppressWarnings("rawtypes")
	public static Map<String, String> getRequstParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        return params;
    }
    
    public static String resolveAdditionalMessage(String message, Object... additionalMessage) {
        return resolveAdditionalMessage(message,true,additionalMessage);
    }
    /**
     *
     * @param message 原始消息
     * @param tailWhenPlaceHolder  当没有占位符时,是否追加消息到末尾  true时追加,否则不追加。
     * @param additionalMessage  附加信息
     * @return
     */
    public static String resolveAdditionalMessage(String message,boolean tailWhenPlaceHolder,Object... additionalMessage) {
        if(CommonUtils.isBlank(additionalMessage)){
            return message;
        }
        try {
            if(hasPlaceholder(message)){
              message = MessageFormat.format(message, additionalMessage);
            }else{
                if(tailWhenPlaceHolder){
                    //没有占位符,直接追加附加信息
                    message+=processAdditionalMessage(additionalMessage);
                }
            }
        } catch (Exception e) {
            System.out.println(message +"  "+ Arrays.asList(additionalMessage).toArray() );
        }
        return message;
    }
    /**
     *判断是否有占位符
     * @param message
     * @return
     */
    private static boolean  hasPlaceholder(String message){
        boolean hasPlaceholderFlag=false; //true表示有占位符,false表示没有占位符
        MessageFormat messageFormat=new MessageFormat(message);   
        //返回占位符个数
        Format[] formats=messageFormat.getFormats();
        if(formats==null){
           return   hasPlaceholderFlag;  
        }
        if(formats.length==0){
          return    hasPlaceholderFlag; 
        }
        //表示有占位符信息
        if(formats.length>0){
           hasPlaceholderFlag=true;
        }
        return hasPlaceholderFlag;
    }
    /**
     *添加追加附加信息
     * @param additionalMessage
     * @return
     */
    private static  String processAdditionalMessage(Object... additionalMessage){
        StringBuffer additionMessageBuffer=new StringBuffer();
        //基本判断处理
        if(additionalMessage==null){
            return additionMessageBuffer.toString();
        }
        if(additionalMessage.length==0){
           return  additionMessageBuffer.toString();
        }
        //遍历信息追加
        for(int i=0;i<additionalMessage.length;i++){
            additionMessageBuffer.append(" | "+additionalMessage[i]);
        }
        return additionMessageBuffer.toString();
    }
}
