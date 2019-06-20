package demo01;

/**
 * @program: rpc10
 * @description:
 * @author: tangliang
 * @create: 2019-06-16 22:58
 **/
public class App {

    public static void main(String[] args) {

        RpcClient rpcClient = new RpcClient();

        IHelloService iHelloService = (IHelloService) rpcClient.getService(IHelloService.class,"127.0.0.1",8080);

        String rsuslt = iHelloService.sayHello("你好，很高兴认识你！");
        System.out.println(rsuslt);
    }


}
