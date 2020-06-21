package com.lagou.serializer;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * @author cjs
 * @version 1.0.0
 * @className JSONSerializer
 * @description TODO
 * @createTime 2020年06月21日 01:27:00
 */
public class JSONSerializer implements Serializer{

    public byte[] serialize(Object object) throws IOException {
        return JSON.toJSONBytes(object);
    }

    public <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException {
        return JSON.parseObject(bytes, clazz);
    }

}
