package basic;

public class SubString {

    public static void main(String[] args){
        String ori = "signal: -29.00 dBm\n" +
                "              \tlast seen: 0 ms ago\n" +
                "              \tSSID: MANGO" ;
        int posMango = ori.indexOf("MANGO");
        int posMh = ori.indexOf(":");
        System.out.println("length:" + ori.length() + " MANGO:" + posMango);
        System.out.println(posMh);

    }
}
