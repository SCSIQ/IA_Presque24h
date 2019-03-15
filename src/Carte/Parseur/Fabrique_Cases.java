package Carte.Parseur;

import Carte.Map;
import Case.Case;
import Case.Type_Case;
import Case.Vigne;
import Case.Chemin;

public class Fabrique_Cases {
    //singleton
    private static Fabrique_Cases instance;

    //---------- CONSTRUCTEURS -----------------------------------------------------
    private Fabrique_Cases() {
    }
//------------------------------------------------------------------------------

    //---------- GETEUR/SETEUR -----------------------------------------------------
    public static Fabrique_Cases get(Map _map) {
        if(instance == null) {
            instance = new Fabrique_Cases();
        }
        return instance;
    }
//------------------------------------------------------------------------------

    //construction d'une case
    public static Case construireCase(Type_Case type, int ligne, int colonne, Map map) {
        Case nouvelleCase = null;
        switch(type) {
            case chemin: nouvelleCase = new Chemin(ligne,colonne,map);
                break;
            case vigne: nouvelleCase = new Vigne(ligne,colonne,map);
                break;
        }
        return nouvelleCase;
    }
}
