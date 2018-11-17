package basic;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.print.DocFlavor;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/18 9:33
 * @description
 **/
public class TcpClient {

    private static Socket socket;
    //private Socket socket;

    public static void main(String[] args){

//        try{
//            socket = new Socket("192.168.1.173",8000);
//            InputStream is = socket.getInputStream();
//            byte[] buffer = new byte[1024];
//            while(is.read(buffer) != -1){
//                String s = new String(buffer,0,is.read(buffer));
//                System.out.println(s);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        String s = "123" + "#" + "456";
        int sign = s.indexOf("#");
        System.out.println(s.substring(0,sign));
        System.out.println(s.substring(sign));

    }

}
