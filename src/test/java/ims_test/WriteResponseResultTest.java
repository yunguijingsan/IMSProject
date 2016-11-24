package ims_test;

import org.junit.Test;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shine.core.exception.ResponseResult;
import com.shine.core.utils.spring.ComplexPropertyPreFilter;

public class WriteResponseResultTest {

	@Test
	public void test(){
      
        try {
            ResponseResult result = ResponseResult.createSuccess();
            SerializeWriter serializeWriter = new SerializeWriter();

            JSONSerializer serializer = new JSONSerializer(serializeWriter);
            serializer.getPropertyFilters().add(new ComplexPropertyPreFilter(result));
            serializer.config(SerializerFeature.WriteMapNullValue, true);
            serializer.config(SerializerFeature.WriteNullBooleanAsFalse, true);
            serializer.config(SerializerFeature.WriteNullNumberAsZero, true);
            serializer.config(SerializerFeature.WriteNullStringAsEmpty, true);
            serializer.write(result);
            
            System.out.println(serializeWriter.toString());
           
        } catch (Exception e) {
       
        }
	}
	@Test
	public void testEmptyString(){
		String s = "";
		System.out.print(s.isEmpty());
	}
	
}
