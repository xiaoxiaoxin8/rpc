package demo01;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @program: rpc10
 * @description: Rpc调用参数类
 * @author: tangliang
 * @create: 2019-06-16 23:38
 **/
public class RpcParam implements Serializable {

    String className;
    String methodName;
    Object[] args;

    public RpcParam(String className,String methodName,Object[] args){
        this.className = className;
        this.methodName = methodName;
        this.args = args;
    }

    public RpcParam(){

    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }


    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public String toString() {
        return "RpcParam{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
