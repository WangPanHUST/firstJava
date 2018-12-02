package reflection.genericReflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/2 19:52
 * @description 8-4，泛型的反射
 **/
public class GenericReflectionTest {

    public static void main(String[] args){
        String name;
        if(args.length > 0){
            name = args[0];
        }else {
            //这里使用带资源的try语句，会在try块退出的时候自动的调用res.close()自动的关闭资源
            try(Scanner in = new Scanner(System.in);){
                System.out.println("Enter class name (e.g. chapter8.pair1.Pair):");
                name = in.next();
            }
        }
        try{
            //这里Class<?>代表[泛型类]类型
            Class<?> cl = Class.forName(name);
            printClass(cl);
            for(Method m:cl.getDeclaredMethods()){
                printMethod(m);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /*
    使用 java.lang.reflect 包中提供的接口 Type。这个接口包含下列子类型：
        •Class 类，描述具体类型。
        •TypeVariable 接口，描述类型变量（如 T extends Comparable<? super T>)
        •WildcardType 接口， 描述通配符 （如？super T )。
        •ParameterizedType 接口， 描述泛型类或接口类型（如 Comparable<? super T>)。
        •GenericArrayType 接口， 描述泛型数组（如 T[ ]。)
*/

    //打印类的基本信息
    public static void printClass(Class<?> cl){

        //这里会打印类名，若输入测试的类是pair1.Pair，则会打印 class pair.Pair
        System.out.print(cl);

        //这里getTypeParameters()会返回一个TypeVariable数组，是泛型类的类型变量,如果类型变量是<T,U>,则返回T和U
        //因为不确定类型变量的个数，所以使用printTypes方法
        printTypes(cl.getTypeParameters(),"<",",",">",true);

        //getGenericSuperclass()会返回带有泛型参数的超类,java允许只能继承自一个类，故这里cl.getGenericSuperclass()只返回一个变量
        Type sc = cl.getGenericSuperclass();

        if(sc != null){
            System.out.print(" extends ");
            printType(sc,false);
        }

        //可以实现多个接口，故cl.getGenericInterfaces()返回值肯不止一个，故用printTypes方法打印
        printTypes(cl.getGenericInterfaces()," inplements ",",","",false);
        System.out.println();
    }

    //打印方法信息
    public static void printMethod(Method m){

        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");

        //这里主要针对的是泛型方法，其在返回类型和修饰符中间还有泛型类型变量，如 public static <T extends Comparable> Pair<T> minmax(T[] a)
        //isDefinition表示该类型变量是否已经定义，如实现了某个接口
        printTypes(m.getTypeParameters(),"<",",",">",true);

        //getGenericReturnType()返回类型只有一个，泛型返回类型
        printType(m.getGenericReturnType(),false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");

        //getGenericParameterTypes()获得泛型参数
        printTypes(m.getGenericParameterTypes(),"",",","",false);
        System.out.println(")");

    }

    //用来打印类型变量及符号:<>，一般会打印<T>,或<T,U> 这样的信息
    public static void printTypes(Type[] types,String pre,String sep,String suf,boolean isDefinition){
        if(pre.equals(" extends ") && Arrays.equals(types,new Type[]{Object.class})){
            return;
        }

        //确定是泛型类型，则会打印pre，一般是"<"
        if(types.length > 0){
            System.out.print(pre);
        }

        //依次打印各个类型变量
        for(int i = 0;i < types.length;i++){

            //对于含多个类型参数的时候适用，如<T,U>，打印中间的逗号
            if(i > 0){
                System.out.print(sep);
            }
            printType(types[i],isDefinition);
        }

        //最后打印">"
        if(types.length > 0){
            System.out.print(suf);
        }
    }

    public static void printType(Type type,boolean isDefinition){
        //超类强制转化为子类时，要用instanceof进行检查，这里type是超类
        if(type instanceof Class){
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }
        //TypeVariable描述类型变量
        else if(type instanceof TypeVariable){
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());

            //如果类型变量定义了，则打印其继承的信息
            if(isDefinition){
                printTypes(t.getBounds()," extends ","&","",false);
            }
        }
        //打印通配符相关信息
        else if(type instanceof WildcardType){
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds()," extends ","&","",false);
            printTypes(t.getLowerBounds()," super ","&","",false);
        }
        //打印泛型类或接口类型
        else if(type instanceof ParameterizedType){
            ParameterizedType t = (ParameterizedType) type;

            //如果是内部类，则打印外部类的信息
            Type owner = t.getOwnerType();
            if(owner != null){
                printType(owner,false);
                System.out.print(".");
            }
            printType(t.getRawType(),false);
            printTypes(t.getActualTypeArguments(),"<",",",">",false);
        }
        //打印泛型数组信息
        else if(type instanceof GenericArrayType){
            GenericArrayType t =(GenericArrayType) type;
            System.out.print("");

            //getGenericComponentType()获得声明数组类型的泛型组件类型
            printType(t.getGenericComponentType(),isDefinition);
            System.out.print("[]");
        }
    }
}
/*
输出：
Enter class name (e.g. chapter8.pair1.Pair):
chapter8.pair1.Pair
class chapter8.pair1.Pair<T> extends java.lang.Object
public T getFirst()
public void setSecond(T)
public T getSecond()
public void setFirst(T)
 */




















