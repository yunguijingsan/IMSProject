package com.shine.core.utils.spring;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.shine.core.exception.ResponseResult;
import com.shine.core.utils.common.ServletObjectContext;
import com.shine.core.utils.encode.DesEncrypt;

/**
 * 自定义json转换器，使用自定义的属性过滤器序列化ResponseResult。
 * CustomFastJsonHttpMessageConverter
 * 创建人:liucf
 * 时间：2016年03月08日 15:41:45
 * @version 1.0.0
 *
 */
public class CustomFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {
    
    public CustomFastJsonHttpMessageConverter() {
        super();
    }


    @Override
    protected void writeInternal(Object object, HttpOutputMessage httpOutputMessage) throws IOException,
                                                                                            HttpMessageNotWritableException {
        if (object instanceof ResponseResult) {
            writeResponseResult(object, httpOutputMessage);
        } else {
            super.writeInternal(object, httpOutputMessage);
        }
       
    }

    @SuppressWarnings("deprecation")
	private void writeResponseResult(Object object, HttpOutputMessage httpOutputMessage) throws java.io.IOException {
        OutputStream out = httpOutputMessage.getBody();
        ResponseResult responseResult = (ResponseResult) object;
        writeResponseResult(out,responseResult,super.getCharset(),super.getFeatures());
    }
    
    public static void writeResponseResult(OutputStream outPutStream,ResponseResult responseResult,Charset charset,SerializerFeature... features) throws IOException {
        SerializeWriter serializeWriter = new SerializeWriter();

        JSONSerializer serializer = new JSONSerializer(serializeWriter);

        serializer.getPropertyFilters().add(new ComplexPropertyPreFilter(responseResult));
        for (SerializerFeature feature : features) {
            serializer.config(feature, true);
        }
        serializer.write(responseResult);
        String result = serializeWriter.toString();
         //加密解决方案
//        if (!responseResult.isDoNotEncrypt()) {
//            result = DesEncrypt.encrypt(result, ServletObjectContext.getToken());
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("result", result);
//            String text = searializedObject(map, features);
//            outPutStream.write(text.getBytes(charset));
//        } else {
//            outPutStream.write(result.getBytes(charset));
//        }
         //无加密解决方案       
        outPutStream.write(result.getBytes(charset));
    }
    
    private static String searializedObject(Object obj,SerializerFeature... features){
        SerializeWriter serializeWriter = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(serializeWriter);
        for (SerializerFeature feature : features) {
            serializer.config(feature, true);
        }
        serializer.write(obj);
        return serializeWriter.toString();
    }

    @Override
    protected Object readInternal(Class<? extends Object> c, HttpInputMessage httpInputMessage) throws IOException,HttpMessageNotReadableException {
        return  super.readInternal(c, httpInputMessage);
  
    }
    
}
