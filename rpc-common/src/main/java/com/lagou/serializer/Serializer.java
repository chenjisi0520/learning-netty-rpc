package com.lagou.serializer;

import java.io.IOException;

/**
 * @author cjs
 * @version 1.0.0
 * @className Serializer
 * @description TODO
 * @createTime 2020年06月21日 01:27:00
 */
public interface Serializer {

  /**
   * java对象转换为二进制
   *
   * @param object
   * @return
   */
  byte[] serialize(Object object) throws IOException;

  /**
   * 二进制转换成java对象
   *
   * @param clazz
   * @param bytes
   * @param <T>
   * @return
   */
  <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException;
}
