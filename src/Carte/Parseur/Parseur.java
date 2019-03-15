package Carte.Parseur;
import Carte.Map;
import Carte.Objet.Cuve_Blanc;
import Carte.Objet.Cuve_Rouge;
import Case.Case;
import Case.Type_Case;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Parseur {
    private Map map;

//---------- CONSTRUCTEURS -----------------------------------------------------

    public Parseur(Map _map) {
        this.map = _map;
    }

//------------------------------------------------------------------------------

    //Parse une ligne du fichier
    public void parseLigne(int numLigne, String ligne, int tailleLigne) {
        for(int numColonne = 0 ; numColonne < tailleLigne ; numColonne++) {
            char c = ligne.charAt(numColonne);
            //creation de la case
            Case nouvelleCase = null;
             switch(c) {
             case 'C' : nouvelleCase = Fabrique_Cases.construireCase(Type_Case.chemin, numLigne, numColonne,this.map); break;
             default : nouvelleCase = Fabrique_Cases.construireCase(Type_Case.vigne, numLigne, numColonne,this.map); break;
             }
            //System.out.println(nouvelleCase);
             this.map.setCase(numLigne, numColonne, nouvelleCase);
        }
    }

    //Lance le parsage du fichier
    public void lectureCase(String ligne) {


        //ouverture du fichier en lecture
        String d = this.removePipe(ligne);
        String[] chaine = d.split("_");
        int nbColonnes = Integer.parseInt(chaine[1]);
        for (int numLigne = 0; numLigne < nbColonnes; numLigne++){
            this.parseLigne(numLigne, chaine[2], nbColonnes);
        }
        this.map.toString();
    }

    public void lectureCuve(String cuves){
        String liste  = cuves.replace(" ", "");
        String[] CoordCuves = this.removePipe(liste).split("_");
        String[] cuveRouge = CoordCuves[1].split(";");
        Cuve_Rouge cr = new Cuve_Rouge();
        Case c =  this.map.getCase(Integer.valueOf(cuveRouge[0]), Integer.valueOf(cuveRouge[1]));
        c.setObjet(cr);
        cr.setCase(c);
        String[] cuveBlanche = CoordCuves[2].split(";");
        Cuve_Blanc cb = new Cuve_Blanc();

        Case c2 =  this.map.getCase(Integer.valueOf(cuveBlanche[0]), Integer.valueOf(cuveBlanche[1]));
        c2.setObjet(cb);
        cb.setCase(c2);

        System.out.println(c.getObjet());
        System.out.println(c2.getObjet());
    }

    public void lectureRaisin(String raisins){

    }

    public String removePipe(String d){
        return d.replace("|", "_");
    }
}
