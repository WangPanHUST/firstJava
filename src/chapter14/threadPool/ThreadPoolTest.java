package chapter14.threadPool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/25 15:14
 * @description 14-11，线程池的使用
 **/
public class ThreadPoolTest {

    public static void main(String[] args) throws Exception{
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Enter the directory:");
            String direcory = in.nextLine();
            System.out.println("Enter keyword:");
            String keyword = in.nextLine();

            //newCachedThreadPool返回ExecutorService接口的ThreadPoolExecutor类的对象
            ExecutorService pool = Executors.newCachedThreadPool();

            MatchCounter counter = new MatchCounter(new File(direcory),keyword,pool);
            Future<Integer> result = pool.submit(counter);

            try{
                System.out.println(result.get() + " maching files.");
            }catch (ExecutionException e){
                e.printStackTrace();
            }catch (InterruptedException e){

            }
            pool.shutdown();

            int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
            System.out.println("largest pool size = " + largestPoolSize);
        }
    }
}

class MatchCounter implements Callable<Integer>{

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory,String keyword,ExecutorService pool){
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }


    @Override
    public Integer call() throws Exception {
        count = 0;
        try{
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for(File file : files){
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file,keyword,pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else{
                    if(search(file)){
                        count++;
                    }
                }
            }

            for(Future<Integer> result : results){
                try{
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
                while(!found && in.hasNextLine()){
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



























