package Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class SocketClient {

    private static Socket s;
    private static Client c;

    public static void main(String[] args) throws IOException, InterruptedException {

        String str = "";
        String command = "INSCRIRE";
        while(!"FIN".equals(str)){
            s = new Socket(InetAddress.getLocalHost(), 1234);
            c = new Client(s);
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println(command);
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufr = new BufferedReader( isr );
            str = bufr.readLine();
        }
        c.Carte();
        s.close();
    }

}