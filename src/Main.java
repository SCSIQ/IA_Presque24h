import Carte.Map;
import Carte.Parseur.Parseur;
import Server.SocketClient;

public class Main {

    public static void main(String[] args) {
        Parseur p = new Parseur(new Map());
        p.lectureCase("OK|4|CCCCCVVCVCCVCCCC");
        //p.lectureCuve("OK|39 ;0|39 ;1|");
    }
}
