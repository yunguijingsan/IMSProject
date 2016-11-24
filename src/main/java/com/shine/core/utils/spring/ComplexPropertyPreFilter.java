package com.shine.core.utils.spring;

import com.alibaba.fastjson.serializer.PropertyFilter;

import com.shine.core.exception.ResponseResult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 自定义的属性过滤器
 * 包含includeMap和excludeMap两个属性
 * 1.使用includeMap声明一个类需要序列化的属性
 * 2.使用excludeMap声明一个类序列化时忽略的属性
 * 3.当声明了includeMap中声明了一个类时，该类的excludeMap失效
 *
 * ComplexPropertyPreFilter
 * 创建人:liucf
 * 时间：2016年03月08日 15:41:45
 * @version 1.0.0
 *
 */
public class ComplexPropertyPreFilter implements PropertyFilter {
    private Map<Class<?>, Set<String>> includeMap = new HashMap<Class<?>, Set<String>>();
    private Map<Class<?>, Set<String>> excludeMap = new HashMap<Class<?>, Set<String>>();
    private Set<String> excludeProperties = new HashSet<String>();

    public ComplexPropertyPreFilter(ResponseResult responseResult) {
        includeMap = responseResult.getIncludeMap();
        excludeMap = responseResult.getExcludeMap();
        excludeProperties.add("lastLogonDate");
        excludeProperties.add("createdBy");
        excludeProperties.add("lastUpdateLogin");
        excludeProperties.add("lastUpdatedBy");
        excludeProperties.add("lastUpdateDate");
        excludeProperties.add("creationDate");
        excludeProperties.add("segment2");
        excludeProperties.add("segment3");
        excludeProperties.add("segment4");
        excludeProperties.add("segment5");
        excludeProperties.add("segment6");
        excludeProperties.add("segment7");
        excludeProperties.add("segment8");
        excludeProperties.add("segment9");
        excludeProperties.add("segment10");
    }

    @Override
    public boolean apply(Object source, String name, Object value) {
        boolean useExcludeFlag = true;
        for (Map.Entry<Class<?>, Set<String>> entry : includeMap.entrySet()) {
            Class<?> clazz = entry.getKey();
            if (source.getClass() == clazz) {
                useExcludeFlag = false;
                Set<String> fields = entry.getValue();
                for (String field : fields) {
                    if (field.equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            }
        }

        if (useExcludeFlag) {
            for (Map.Entry<Class<?>, Set<String>> entry : excludeMap.entrySet()) {
                Class<?> clazz = entry.getKey();
                if (source.getClass() == clazz) {
                    Set<String> fields = entry.getValue();
                    for (String field : fields) {
                        if (field.equalsIgnoreCase(name)) {
                            return false;
                        }
                    }
                }
            }
            if (this.excludeProperties.contains(name)) {
                return false;
            }
            if ( 
                name.toLowerCase().startsWith("attribute") || 
                name.toLowerCase().startsWith("addrattribute") || 
                name.toLowerCase().startsWith("addinformation") ||
                name.toLowerCase().startsWith("perinformation")
                ){
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
