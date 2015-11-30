package com.plugins.netty.serializer;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.objenesis.ObjenesisStd;

/**
 * Created by zhangtao on 2015/11/30.
 */
public class ProtocbuffSerializer implements  Serializer{

    @Override
    public <T> byte[] serialize(T obj) throws Exception {
        @SuppressWarnings("unchecked")
        Class<T> cls = (Class<T>) obj.getClass();
        Schema<T> schema = (Schema<T>) RuntimeSchema.createFrom(cls);
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> cls) throws Exception {
        if(null==bytes)
            return null ;
        T message = (T) new ObjenesisStd(true).newInstance(cls);
        Schema<T> schema = (Schema<T>)RuntimeSchema.createFrom(cls);
        ProtostuffIOUtil.mergeFrom(bytes, message, schema);
        return message;
    }
}
