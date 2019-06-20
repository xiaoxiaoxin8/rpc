package demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: rpc10
 * @description: Rpc调用代理
 * @author: tangliang
 * @create: 2019-06-16 22:26
 **/
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 发布服务
     * @param service 需要发布的实例
     * @param port 监听的端口
     */
    public void publish(Object service,int port){

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                executorService.execute(new HandleProxyServer(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
