package chapter14.future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/24 10:33
 * @description 14-10，Callable和Future的使用，Callable是有返回值的Runnable
 **/
public class FutureTest {

    public static void main(String[] args){
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Enter base directory:");
            String directory = in.nextLine();
            System.out.println("Enter keyword:");
            String keyword = in.nextLine();

            MatchCounter counter = new MatchCounter(new File(directory),keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            Thread t = new Thread(task);
            t.start();

            try{
                System.out.println(task.get() + "matching fils.");
            }catch (ExecutionException e){
                e.printStackTrace();
            }
        }catch (InterruptedException e){

        }
    }
}

class MatchCounter implements Callable<Integer>{

    private File directory;
    private String keyword;

    public MatchCounter(File aDirectory,String aKeyword){
        this.directory = aDirectory;
        this.keyword = aKeyword;
    }

    @Override
    public Integer call() {
        int count = 0;
        try{
            File[] files = directory.listFiles();
            //可以声明接口变量，此变量必须引用实现了接口的类对象
            List<Future<Integer>> results = new ArrayList<>();

            for(File file : files){
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file,keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }else{
                    if(search(file)){
                        count++;
                    }
                }
            }

            for(Future<Integer> result : results){
                try{
                    //result.get()返回的是每个call的count
                    count += result.get();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }
            }
        }catch (InterruptedException e){

        }
        return count;
    }

    public boolean search(File file){
        try{
            try(Scanner in = new Scanner(file,"UTF-8")){
                boolean found = false;
                while (!found && in.hasNextLine()){
                    String line = in.nextLine();
                    if(line.contains(keyword)){
                        found = true;
                    }
                }
                return found;
            }
        }catch (IOException e){
            return false;
        }
    }
}















