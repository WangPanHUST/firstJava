package chapter6.staticInnerClass;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/9 18:42
 * @description 6-9，静态内部类的使用，静态内部类不能访问外围类对象
 **/
public class StaticInnerClassTest {

    public static void main(String[] args){
        double[] d = new double[20];
        for(int i = 0;i<d.length;i++){
            d[i] = 100 * Math.random();
        }

        //pair是ArrayAlg的静态内部类，minmax（）返回的正是pair类
        ArrayAlg.pair pair = ArrayAlg.minmax(d);
        System.out.println("min = " + pair.getFirst());
        System.out.println("max = " + pair.getSecond());

    }

}

class ArrayAlg{

    public static class pair{

        private double first;
        private double second;

        public pair(double f,double s){
            first = f;
            second = s;
        }

        public double getFirst(){
            return first;
        }

        public double getSecond(){
            return second;
        }

    }

    public static pair minmax(double[] values){
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        for(double v : values){
            if(v < min){
                min = v;
            }
            if(v > max){
                max = v;
            }
        }

        return new pair(min,max);
    }
}











