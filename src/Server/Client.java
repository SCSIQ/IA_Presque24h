package Server;

import Carte.Map;
import Carte.Parseur.Parseur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    private Socket s;

    public Client(Socket s){
        this.s = s;
    }

    public void Carte() throws IOException {

        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufr = new BufferedReader( isr );
        String str = bufr.readLine();
        Map m = new Map();
        Parseur p = new Parseur(m);
        p.lectureCase(str);
        System.out.println(str);
    }

}
