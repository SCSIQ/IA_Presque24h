package Joueur;

import Carte.Objet.Raisin_Blanc;
import Carte.Objet.Raisin_Rouge;
import Carte.Objet.Type_Objet;
import Case.Case;
import IA.Type_Action;

public class Joueur {

    //ATTRIBUTS
    private Case saCase;
    private int score;
    private Hotte hotte;
    private int pointAction; //non cumulable à reinitialiser à chaque tour

    //CONSTRUCTEUR
    public Joueur(Case saCase)
    {
        pointAction=10;
        hotte = new Hotte();
        this.saCase=saCase;

    }

    //METHODES
    public Type_Action deplacerJoueur(Case caseSuivante)
    {
        Type_Action deplacement=Type_Action.attendre;

        if(caseSuivante.franchissable())//vérifie si franchissable
        {
            if(pointAction>0)
            {
                if(caseSuivante==this.saCase.getDroite())
                {
                    this.saCase=caseSuivante;
                    deplacement=Type_Action.deplacement_droite;
                }
                else if(caseSuivante==this.saCase.getBas())
                {
                    this.saCase=caseSuivante;
                    deplacement=Type_Action.deplacement_bas;
                }
                else if(caseSuivante==this.saCase.getGauche())
                {
                    this.saCase=caseSuivante;
                    deplacement=Type_Action.deplacement_gauche;
                }
                else if(caseSuivante==this.saCase.getHaut())
                {
                    this.saCase=caseSuivante;
                    deplacement=Type_Action.deplacement_haut;
                }

                this.setPointAction(this.getPointAction()-1);
            }
            else
            {
               System.out.println("Vous n'avez pas assez de points d'actions");
            }

        }

        return deplacement;
    }


    /**
     *
     * raisin et si type raisin != type raisin dans hotte -> ne ramasse pas
     */
    public void ramasser()
    {
        if(saCase.getObjet().getType()!= Type_Objet.Cuve_Blanc || saCase.getObjet().getType()!= Type_Objet.Cuve_Rouge )
        {
            if (hotte.getNombreRaisin() == 0 && pointAction>0) {
                hotte.setTypeRaisin(saCase.getObjet().getType());

                if(saCase.getObjet().getType()== Type_Objet.Blanc)
                {
                    hotte.setNombreRaisin(((Raisin_Blanc)saCase.getObjet()).getQte());
                }
                else
                {
                    hotte.setNombreRaisin(((Raisin_Rouge)saCase.getObjet()).getQte());
                }

                saCase.setObjet(null);
                this.setPointAction(this.getPointAction()-1);
            }
            else if (hotte.getTypeRaisin() == saCase.getObjet().getType() && pointAction>0)
            {
                if(saCase.getObjet().getType()== Type_Objet.Blanc)
                {
                    hotte.setNombreRaisin(((Raisin_Blanc)saCase.getObjet()).getQte());
                }
                else
                {
                    hotte.setNombreRaisin(((Raisin_Rouge)saCase.getObjet()).getQte());
                }
                saCase.setObjet(null);
                this.setPointAction(this.getPointAction()-1);
            }
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
