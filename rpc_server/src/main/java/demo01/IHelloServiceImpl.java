package demo01;

/**
 * @program: rpc10
 * @description:
 * @author: tangliang
 * @create: 2019-06-16 22:21
 **/
public class IHelloServiceImpl implements IHelloService{

    public String sayHello(String str) {
        System.out.println("I am Tommy,"+str);
        return "SUCCESS,"+str;
    }
}
