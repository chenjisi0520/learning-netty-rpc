package com.lagou.convert;

import com.lagou.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author cjs
 * @version 1.0.0
 * @className RpcEncoder
 * @description TODO
 * @createTime 2020年06月21日 12:41:00
 */
public class RpcEncoder extends MessageToByteEncoder {

  private Class<?> clazz;
  private Serializer serializer;

  public RpcEncoder(Class<?> clazz, Serializer serializer) {
    this.clazz = clazz;
    this.serializer = serializer;
  }

  protected void encode(ChannelHandlerContext channelHandlerContext, Object msg, ByteBuf byteBuf)
      throws Exception {

    if (clazz != null && clazz.isInstance(msg)) {
      byte[] bytes = serializer.serialize(msg);
      byteBuf.writeInt(bytes.length);
      byteBuf.writeBytes(bytes);
    }
  }
}
