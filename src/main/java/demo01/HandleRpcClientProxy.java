package demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: rpc10
 * @description: 处理发送rpc的代理类
 * @author: tangliang
 * @create: 2019-06-16 23:21
 **/
public class HandleRpcClientProxy implements InvocationHandler {

    int port;
    String hostip;
    RpcSocketClient rpcSocketClient;

    public HandleRpcClientProxy(String hostip,int port){
        this.port = port;
        this.hostip = hostip;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //String classname = proxy.getClass().getName();
        String classname = method.getDeclaringClass().getName();
        String methodname = method.getName();

        rpcSocketClient = new RpcSocketClient(hostip,port);
        Object result = rpcSocketClient.send(classname,methodname,args);
        return result;
    }

}
