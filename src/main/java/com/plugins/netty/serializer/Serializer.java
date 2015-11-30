package com.plugins.netty.serializer;

/**
 * Created by zhangtao on 2015/11/30.
 */
public interface Serializer {

    /**
     * 序列化
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> byte[] serialize(T obj) throws Exception;

    /**
     * 反序列化
     * @param bytes
     * @param cls
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T>T deserialize(byte[] bytes, Class<T> cls) throws Exception;
}
