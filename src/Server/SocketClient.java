package Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

    private static Socket s;
    private static Client c;

    public static void main(String[] args) throws IOException {

        s = new Socket(InetAddress.getLocalHost(), 1234);
        c = new Client(s);
        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        pw.println("CARTE");
        /*InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufr = new BufferedReader( isr );
        String str = bufr.readLine();
        while(str.equals("FIN")){
            // TODO passage des instructions.
            //pw.println(instruction);
        }
        System.out.println(str);*/
        c.Carte();
        s.close();
    }

}