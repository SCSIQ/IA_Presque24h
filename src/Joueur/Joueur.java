package Joueur;

import Case.Case;

public class Joueur {

    //ATTRIBUTS
    private Case saCase;
    private int score;
    private Hotte hotte;
    private int pointAction; //non cumulable

    //CONSTRUCTEUR
    public Joueur(Case saCase)
    {
        pointAction=10;
        hotte = new Hotte();
        this.saCase=saCase;

    }

    //METHODES
    public void deplacerJoueur()
    {

    }


    /**
     *
     * @return true si raisin (false si != raisin et si type raisin != type raisin dans hotte
     */
    public boolean ramasser()
    {

        return false;
    }

    public void viderHotte()
    {


    }

    //GETTER SETTER
    public int getPointAction() {
        return pointAction;
    }

    public void setPointAction(int pointAction) {
        this.pointAction = pointAction;
    }

    public Case getSaCase() {
        return saCase;
    }

}
