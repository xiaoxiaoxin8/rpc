package demo01;

/**
 * @program: rpc10
 * @description:
 * @author: tangliang
 * @create: 2019-06-17 00:36
 **/
public class ServerApp {

    public static void main(String[] args) {

        RpcProxyServer rpcProxyServer = new RpcProxyServer();

        IHelloService iHelloService = new IHelloServiceImpl();

        rpcProxyServer.publish(iHelloService,8080);
    }

}
