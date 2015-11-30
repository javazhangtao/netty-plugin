package com.plugins.rpc.proxy;

import com.plugins.rpc.protocol.RpcResponce;
import com.plugins.suppor.Constans;
import com.plugins.suppor.MethodMapping;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 服务端方法执行
 * Created by zhangtao on 2015/11/30.
 */
public class ServerProxy {

    /**
     *  方法执行
     * @param targetObject
     * @param methodName
     * @param parameterTypes
     * @param parameters
     * @return
     */
    public RpcResponce execute(Object targetObject, String methodName, Class<?>[] parameterTypes, Map<String, String> parameters){
        RpcResponce responce = null;
        try {
            responce = new RpcResponce();
            FastClass serviceFastClass = FastClass.create(targetObject.getClass());
            FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);
            responce.setResult(serviceFastMethod.invoke(targetObject, _getParams(serviceFastMethod.getJavaMethod(), parameters)));
            responce.setCode(Constans.RESPONCE_CODE_SUCCESS);
        } catch (InvocationTargetException e) {
            responce.setCode(Constans.RESPONCE_CODE_ERROR);
            responce.setError(e);
            responce.setMessage("Execute proxy methond error");
        }
        return responce;
    }


    /**
     *  获取调用方法参数对应
     * @param method
     * @param parameters
     * @return
     */
    Object[] _getParams(final Method method,final Map<String, String> parameters){
        if(null==parameters || parameters.isEmpty())
            return new Object[0];
        MethodMapping mapping=new MethodMapping();
        String[] paramNames= mapping.getMethodParams(method);
        Object[] _params=new Object[parameters.size()];
        for (int i = 0; i < paramNames.length; i++) {
            if(parameters.containsKey(paramNames[i]))
                _params[i]=parameters.get(paramNames[i]);
            else
                _params[i]=null;
        }
        return _params;
    }
}
