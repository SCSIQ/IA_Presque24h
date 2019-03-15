package IA;

import Joueur.Joueur;
import Carte.Map;
import Case.Case;

public abstract class IA {
    private Joueur entite;                                                      //Entité liée à l'IA

//---------- CONSTRUCTEURS -----------------------------------------------------

    public IA(Joueur _entite) {
        this.entite = _entite;
    }
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    //Renvoie l'entité
    public Joueur getEntite() {
        return this.entite;
    }

    //Renvoie la case de l'entité
    public Case getCase() {
        return this.entite.getSaCase();
    }

    //Renvoie la carte du jeu
    public Map getMap() {
        return this.entite.getSaCase().getMap();
    }

    //Méthode appelé à chaque pulsation de la musique et devant renvoyer l'action à réaliser
    public abstract Type_Action action();
//------------------------------------------------------------------------------

    public Type_Action directionDeplacement(int X, int Y, Case caseSuivante){
        Type_Action res=Type_Action.attendre;
        if (caseSuivante.getLigne() == (X - 1)){
            res = Type_Action.deplacement_haut;
        }
        else if (caseSuivante.getLigne() == (X+1)){
            res = Type_Action.deplacement_bas;
        }
        else if (caseSuivante.getColonne() == (Y-1)){
            res = Type_Action.deplacement_gauche;
        }
        else if (caseSuivante.getColonne() == (Y+1) ){
            res = Type_Action.deplacement_droite;
        }
        return res;
    }

}
