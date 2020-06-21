package com.lagou.boot;

import com.lagou.client.RPCConsumer;
import com.lagou.param.RpcRequest;
import com.lagou.service.IUserService;

public class ConsumerBoot {

  public static void main(String[] args) throws InterruptedException {
    // 参数定义
    RpcRequest param = new RpcRequest();
    param.setRequestId("test");
    param.setClassName("com.lagou.service.UserServiceImpl");
    param.setMethodName("sayHello");
    param.setParameterTypes(new Class<?>[] {RpcRequest.class});
    param.setParameters(new Object[] {param});
    // 1.创建代理对象
    IUserService service = (IUserService) RPCConsumer.createProxy(IUserService.class, param);

    // 2.循环给服务器写数据
    while (true) {
      String result = service.sayHello(param);
      System.out.println(result);
      Thread.sleep(2000);
    }
  }
}
