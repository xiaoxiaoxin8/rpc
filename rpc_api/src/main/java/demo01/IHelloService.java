package demo01;

/**
 * @program: rpc10
 * @description: hello接口
 * @author: tangliang
 * @create: 2019-06-16 22:18
 **/
public interface IHelloService {

    /**
     * @param str 招呼词
     */
    public String sayHello(String str);
}
