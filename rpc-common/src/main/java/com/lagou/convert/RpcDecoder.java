package com.lagou.convert;

import com.lagou.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * @author cjs
 * @version 1.0.0
 * @className RpcDecoder
 * @description TODO
 * @createTime 2020年06月21日 12:41:00
 */
public class RpcDecoder extends ByteToMessageDecoder {

  private Class<?> clazz;
  private Serializer serializer;

  public RpcDecoder(Class<?> clazz, Serializer serializer) {
    this.clazz = clazz;
    this.serializer = serializer;
  }

  protected void decode(
      ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list)
      throws Exception {
    if (clazz != null) {
      int length = byteBuf.readInt();
      // 解析消息体
      byte[] data = new byte[length];
      byteBuf.readBytes(data);
      Object object = serializer.deserialize(clazz, data);
      list.add(object);
    }
  }
}
