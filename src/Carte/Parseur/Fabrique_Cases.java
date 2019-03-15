package Carte.Parseur;

import Case.Case;

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

        }
        return nouvelleCase;
    }
}
