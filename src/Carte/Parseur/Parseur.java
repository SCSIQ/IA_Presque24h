package Carte.Parseur;
import Carte.Map;
import Case.Case;
import Case.Type_Case;
import Objet.*;
import Joueur.Joueur;
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

        for(int numColonne =0 ; numColonne < tailleLigne; numColonne++) {
            char c = ligne.charAt(numColonne);
            //creation de la case
            Case nouvelleCase = null;
             switch(c) {
             case 'C' : nouvelleCase = Fabrique_Cases.construireCase(Type_Case.chemin, numLigne, numColonne,this.map); break;
             default : nouvelleCase = Fabrique_Cases.construireCase(Type_Case.vigne, numLigne, numColonne,this.map); break;
             }
            this.map.setCase(numLigne, numColonne, nouvelleCase);

        }
    }

    //Lance le parsage du fichier
    public void lectureCase(String ligne) {


        //ouverture du fichier en lecture
        String d = this.removePipe(ligne);
        String[] chaine = d.split("_");
        int nbColonnes = Integer.parseInt(chaine[1]);
        String[] dd = new String[nbColonnes];
        int nb = 0;
        int pos = 0;
        String ca = "";

        for (char c : chaine[2].toCharArray()             ) {
            ca += c;
            nb++;
            if (nb == nbColonnes){
                dd[pos] = ca;
                nb = 0;
                pos++;
                ca = "";
            }
        }
        for (int numLigne = 0; numLigne < nbColonnes; numLigne++){
            this.parseLigne(numLigne, dd[numLigne], nbColonnes);
        }
        System.out.println(map);
        this.map.genererGrapheSimple();

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
    }

    public void lectureRaisin(String raisins){
        for(Case c : this.map.getListeCase()){
            if(c.getObjet()!= null){
                if(!(c.getObjet().getType() == Type_Objet.Cuve_Blanc ||c.getObjet().getType() == Type_Objet.Cuve_Rouge) ){
                    c.setObjet(null);
                }
            }
        }
        String raisin = this.removePipe(raisins);
        String[] emplacement = raisin.split("_");
        int nbRaisin = emplacement.length-1;
        for(int i = 1; i <= nbRaisin; i++){
            String[] leRaisin = emplacement[i].split(";");
            Type_Objet typeRaisin;
            Case c = this.map.getCase(Integer.valueOf(leRaisin[2]), Integer.valueOf(leRaisin[3]));
            if(leRaisin[0].equals("ROUGE")){
                c.setObjet(new Raisin_Rouge(c,Integer.valueOf(leRaisin[1])));
            }
            else {
                c.setObjet(new Raisin_Blanc(c,Integer.valueOf(leRaisin[1])));
            }


        }
    }

    public void addPlayer(String chaine, int numEquipe){
        for(Case c : this.map.getListeCase()){
            c.setJoueur(null);
        }
        String bonneChaine = this.removePipe(chaine);
        String[] listeEquipe = bonneChaine.split("_");
        String[] coordEquipe = listeEquipe[numEquipe].split(";");
        Case c= this.map.getCase(Integer.parseInt(coordEquipe[0]), Integer.parseInt(coordEquipe[1]));
        c.setJoueur(new Joueur(c));
     }

    public String removePipe(String d){
        return d.replace("|", "_");
    }
}
