package demo01;

import java.lang.reflect.Proxy;

/**
 * @program: rpc10
 * @description: rpc客户端调用
 * @author: tangliang
 * @create: 2019-06-16 22:58
 **/
public class RpcClient {

    /**
     * 获取服务对象
     * @param clazz
     * @param port
     * @return
     */
    public <T>T getService(Class clazz,String hostip,int port){
        //使用代理对象
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class<?>[]{clazz},new HandleRpcClientProxy(hostip,port));
    }

}
