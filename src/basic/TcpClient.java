package basic;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import javax.print.DocFlavor;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/12/28 9:33
 * @description
 **/
public class TcpClient {

    public static void main(String[] args){
        //客户端
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

        //服务器端
        Socket socket;

        try{
            ServerSocket serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();
            if(socket.isConnected()){
                System.out.println("Connected!");
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream os = socket.getOutputStream();
            byte[] s = "Connected!".getBytes();
            os.write(s);

            //这种接收方式需要send按钮两次才收到一次
//            InputStream is = socket.getInputStream();
//            byte[] buffer = new byte[4086];
//            while(is.read(buffer) != -1){
//                String s = new String(buffer,0,is.read(buffer));
//                System.out.println(s);
//            }

            //接收信息的另一种方式
            boolean flag = true;
            while(flag){
                try{
                    String msg = in.readLine();
                    String IP = socket.getInetAddress().getHostAddress();
                    if(!(msg.equals("") && msg == null)){
                        System.out.println("msg :" + msg + "  Client : " + IP);
                        byte[] buffer = ("Server received: " + msg).getBytes();
                        os.write(buffer);
                    }else{
                        flag = false;
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}