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
     * raisin et si type raisin != type raisin dans hotte -> ne ramasse pas
     */
    public void ramasser()
    {

        if (hotte.getNombreRaisin() == 0 && pointAction>0) {
            hotte.setTypeRaisin(saCase.getRaisin().getType());
            hotte.setNombreRaisin(saCase.getRaisin().getQte());
            this.setPointAction(this.getPointAction()-1);
        }
        else if (hotte.getTypeRaisin() == saCase.getRaisin().getType() && pointAction>0)
        {
            hotte.setNombreRaisin(saCase.getRaisin().getQte());
            this.setPointAction(this.getPointAction()-1);
        }

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
