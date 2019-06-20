package demo01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: rpc10
 * @description: 发送rpc请求工具类
 * @author: tangliang
 * @create: 2019-06-16 23:25
 **/
public class RpcSocketClient {

    private String hostip;
    private int port;

    public  RpcSocketClient(String hostip,int port){
        this.hostip = hostip;
        this.port = port;
    }

    /**
     * 发送rpc
     */
    public Object send(String classname,String methodname,Object[] args){
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        Object result = null;
        try {
            Socket socket = new Socket(hostip,port);

            RpcParam param = new RpcParam();
            //设置classname,methodname,args
            param.setClassName(classname);
            param.setMethodName(methodname);
            param.setArgs(args);

            //获取输出流
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(param);
            outputStream.flush();

            //获取输入流返回结果
            inputStream = new ObjectInputStream(socket.getInputStream());
            result = inputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
