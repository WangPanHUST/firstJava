package proxy;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/10 19:51
 * @description the use of proxies
 **/
public class ProxyTest {

    public static void main(String[] args){

        Object[] elements = new Object[1000];
        for(int i = 0;i < elements.length;i++){
            Integer value = i + 1;

            //value是Object类对象
            InvocationHandler handler = new TraceHandler(value);

            //创建代理对象，Object类型
            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length) + 1;
        System.out.println(key);

        int result = Arrays.binarySearch(elements,key);

        if(result >= 0){
            System.out.println(elements[result]);
        }
    }

}

class TraceHandler implements InvocationHandler{

    private Object target;

    public TraceHandler(Object obj){
        target = obj;
    }

    /**
    * @Description: InvocationHandler接口定义的方法
    * @Param: [proxy, m, args],proxy代理对象本身，m代理对象当前调用的方法，args方法参数
    * @return: java.lang.Object
    * @Author: WangPan wangpanhust@qq.com
    * @Date: 2018/10/10 20:52
    */
    public Object invoke(Object proxy, Method m,Object[] args) throws Throwable{

        System.out.print(target);

        System.out.print("." + m.getName() + "(");

        if(args != null){
            for(int i = 0;i < args.length;i++){
                System.out.print(args[i]);
                if(i < args.length - 1){
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");

        //调用真实对象的方法
        return m.invoke(target,args);
    }
}
