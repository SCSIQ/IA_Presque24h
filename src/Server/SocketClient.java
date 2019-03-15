package Server;

import IA.IA_dijkstra;
import IA.Type_Action;
import Joueur.Joueur;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class SocketClient {

    private static Socket s;
    private static Client c;

    public static void main(String[] args) throws IOException, InterruptedException {


        //IA hello = new IA_dijkstra();
        String str = "";
        String command = "";
        int PA = 0;
        s = new Socket(InetAddress.getLocalHost(), 1234);
        c = new Client(s);
        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufr = new BufferedReader( isr );
        command = "INSCRIRE";
        pw.println(command);
        str = bufr.readLine();
        int eq = Integer.parseInt(""+str.charAt(3));
        System.out.println(str);
        boolean tour1 = true;
        do{
            String raisin = bufr.readLine();
            if(tour1){
                command = "CARTE";
                pw.println(command);
                str = bufr.readLine();
                c.Carte(str);

                command = "CUVES";
                pw.println(command);
                str = bufr.readLine();
                c.Cuves(str);
                tour1 = false;
            }
            //Créer les raisins
            c.Raisin(raisin);
            //Demander joueurs
            command = "JOUEURS";
            pw.println(command);
            str = bufr.readLine();
            Joueur j = c.Joueurs(str, eq);
            //Demander score

            IA_dijkstra ia = new IA_dijkstra(j);
            for(int i=0; i<=9; i++) {
                //Actions IA
                Type_Action action = ia.action();
                switch(action){
                    case deplacement_bas: command = "DEPLACE|BAS";
                    break;

                    case deplacement_droite: command = "DEPLACE|DROITE";
                        break;
                    case deplacement_gauche: command = "DEPLACE|GAUCHE";
                        break;
                    case deplacement_haut: command = "DEPLACE|HAUT";
                        break;
                    case ramasser: command = "RAMASSE";
                        break;
                    case vider: command = "VIDER";
                        break;
                }
                pw.println(command);
                str = bufr.readLine();
            }
            command = "FINTOUR";
            pw.println(command);
            str = bufr.readLine();
        }while("FIN".equals(str));
        s.close();

    }

}