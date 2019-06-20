package demo01;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @program: rpc10
 * @description: 处理代理服务
 * @author: tangliang
 * @create: 2019-06-16 22:42
 **/
public class HandleProxyServer implements Runnable{

    Socket socket;
    Object service;

    public HandleProxyServer(Socket socket,Object service){
        this.socket = socket;
        this.service = service;
    }

    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            //获取输入流
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcParam object = (RpcParam) inputStream.readObject();
            //调用参数
            Object result = invoke(object);
            //获取输出流返回
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 调用参数
     * @param proxy
     * @return
     */
    private Object invoke(RpcParam proxy) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String classname = proxy.getClassName();
        //获取服务调用的方法名
        String methodname = proxy.getMethodName();
        //获取服务调用的参数
        Object[] args = proxy.getArgs();
        //设置参数和类型
        Class<?>[] types = new Class<?>[args.length];
        for(int i=0; i<args.length ; i++){
            types[i] = args[i].getClass();
        }
        //根据类名反射出对象
        Class clazz = Class.forName(classname);
        //传入方法名和参数类型获取方法
        Method method = clazz.getMethod(methodname,types);
        //调用传入的对象
        //Class clazzService = Class.forName(service.getClass().getName());
        Object result = method.invoke(service,args);
        return result;
    }
}
