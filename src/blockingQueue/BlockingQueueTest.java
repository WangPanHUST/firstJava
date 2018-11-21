package blockingQueue;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/21 11:51
 * @description
 **/
public class BlockingQueueTest {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 10;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args){

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

    public static void search(File file,String keyword) throws IOException{

    }
}
