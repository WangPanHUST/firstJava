package chapter14.blockingQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/21 11:51
 * @description 14-9，使用阻塞队列控制一组线程，搜索目录下的所有文件并打印出含指定关键字的行
 **/
public class BlockingQueueTest {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 10;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args){
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Enter base directory:");
            String directory = in.nextLine();
            System.out.println("Enter keyword:");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try{
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                }catch (InterruptedException e){

                }
            };
            new Thread(enumerator).start();

            //主线程先执行，故先print出的queue都是空的，之后再执行子线程Thread(enumerator)
            System.out.println(queue.size());
            //这里让主线程延迟1秒，保证子线程执行完毕，这时queue是读取全部文件之后的
            Thread.sleep(1000);
            System.out.println(queue);
            System.out.println(queue.size());

            for(int i = 1;i <= 2;i++){
                Runnable searcher = () -> {
                    try{
                        boolean done = false;
                        while(!done){
                            File file = queue.take();
                            if(file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else {
                                search(file,keyword);
                            }
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }catch (InterruptedException e){

                    }
                };
                new Thread(searcher).start();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void enumerate(File directory) throws InterruptedException{
        File[] files = directory.listFiles();
        for (File file : files){
            if(file.isDirectory()){
                enumerate(file);
            }else {
                queue.put(file);
            }
        }
    }

    public static void search(File file,String keyword) throws IOException {
        try(Scanner in = new Scanner(file,"UTF-8")){
            int lineNumber = 0;
            while(in.hasNextLine()){
                lineNumber++;
                String line = in.nextLine();
                if(line.contains(keyword)){
                    System.out.printf("%s:%d:%s,%s%n",file.getPath(),lineNumber,line,Thread.currentThread());
                }
            }
        }
    }
}
