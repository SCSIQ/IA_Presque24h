package Server;

import Carte.Map;
import Carte.Parseur.Parseur;
import Joueur.Joueur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    private Socket s;
    private Map m;

    public Client(Socket s){
        this.s = s;
        m = new Map();
    }

    public void Carte(String map) throws IOException {

        /*InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufr = new BufferedReader( isr );
        String str = bufr.readLine();*/
        Parseur p = new Parseur(m);
        p.lectureCase(map);
    }

    public void Cuves(String c) throws IOException{
        Parseur p = new Parseur(m);
        p.lectureCuve(c);
    }

    public void Raisin(String s) throws IOException{
        Parseur p = new Parseur(m);
        p.lectureRaisin(s);
    }

    public Joueur Joueurs(String s, int i) throws IOException{
        Parseur p = new Parseur(m);
        return p.addPlayer(s,i);

    }


}
