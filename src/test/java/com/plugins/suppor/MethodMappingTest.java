package com.plugins.suppor;

import com.plugins.rpc.proxy.ServerProxy;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by zhangtao on 2015/11/30.
 */
public class MethodMappingTest {

    @Test
    public void testGetMethodParams() throws Exception {
        Class clazz=ServerProxy.class;
        Method m=clazz.getMethod("execute",Object.class,String.class,Class[].class, Map.class);
        MethodMapping mm=new MethodMapping();
        String[] s=mm.getMethodParams(m);
        System.out.println();
    }
}