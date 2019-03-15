package Case;

import Joueur.Joueur;
import Carte.Map;
import Carte.Objet.Raisin;

import static Case.Type_Case.vigne;

public abstract class Case {



    //ATTRIBUTS
    private int ligne;
    private int colonne;
    private Joueur joueur=null;
    private Raisin raisin;
    private Map map;


    //CONSTRUCTEUR
    public Case(int ligne, int colonne, Map map)
    {
        this.ligne=ligne;
        this.colonne=colonne;
        this.joueur=null;
        this.raisin=null;
        this.map=map;
    }


    //DEPLACEMENTs
    public Case getDroite()
    {
        return map.getCase(ligne,colonne+1);
    }

    public Case getGauche()
    {
        return map.getCase(ligne,colonne-1);
    }

    public Case getHaut()
    {
        return map.getCase(ligne-1,colonne);
    }

    public Case getBas()
    {
        return map.getCase(ligne+1,colonne);
    }

    //GETTER SETTER
    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setMap(Raisin raisin) {
        this.raisin = raisin;
    }

    public void setJoueur(Joueur joueur) {this.joueur = joueur; }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setMap(Joueur joueur) {
        this.joueur = joueur;
    }

    public Raisin getRaisin() {
        return raisin;
    }
    public void setRaisin(Raisin raisin) {
        this.raisin = raisin;
    }





    //METHODES

    public abstract Type_Case getType();

    /**
     *
     * @return true si personne dans case( si un joueur ou si case=vigne _>  false)
     */
    public boolean franchissable()
    {
        boolean rep=true;

        if(this.joueur !=null)
        {
            rep=false;
        }

        if(this.getType()==vigne)
        {
            rep=false;
        }

        return rep;
    }

    public Case[] getVoisines()
    {
        Case[] voisines = new Case[4];

        voisines[0] = getHaut();
        voisines[1] = getBas();
        voisines[2] = getGauche();
        voisines[3] = getDroite();

        return voisines;

    }

    public String toString()
    {
        return getLigne()+"/"+getColonne();
    }

}
