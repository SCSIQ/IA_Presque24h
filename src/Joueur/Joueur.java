package Joueur;

import Objet.Raisin_Blanc;
import Objet.Raisin_Rouge;
import Objet.Type_Objet;
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
               System.out.println("Pour se déplacer : Vous n'avez pas assez de points d'actions");
            }

        }

        return deplacement;
    }

public void setCase(Case c){ this.saCase=c;}
    /**
     *
     * raisin et si type raisin != type raisin dans hotte -> ne ramasse pas
     */
    public void ramasser()
    {
        if(hotte.estPleine()==false) //vérifie si la hotte est pleine ou si assez de points d'actions
        {
            if(saCase.getObjet().ramassable()==true) //vérifie si c'est des raisins
            {
                if (hotte.getNombreRaisin() == 0 ) { //Si on a pas encore rammassé de raisin et qu'on a des points d'actions
                    hotte.setTypeRaisin(saCase.getObjet().getType());

                    if(saCase.getObjet().getType()== Type_Objet.Blanc)
                    {
                        hotte.setNombreRaisin(hotte.getNombreRaisin()+((Raisin_Blanc)saCase.getObjet()).getQte());
                    }
                    else
                    {
                        hotte.setNombreRaisin(hotte.getNombreRaisin()+((Raisin_Rouge)saCase.getObjet()).getQte());
                    }

                    saCase.setObjet(null);
                    saCase.getMap().getListeObjet().remove(saCase.getObjet());
                    this.setPointAction(this.getPointAction()-1);
                }
                else if (hotte.getTypeRaisin() == saCase.getObjet().getType())
                {
                    if(saCase.getObjet().getType()== Type_Objet.Blanc)
                    {
                        hotte.setNombreRaisin(hotte.getNombreRaisin()+((Raisin_Blanc)saCase.getObjet()).getQte());
                    }
                    else
                    {
                        hotte.setNombreRaisin(hotte.getNombreRaisin()+((Raisin_Rouge)saCase.getObjet()).getQte());
                    }

                    saCase.setObjet(null);
                    saCase.getMap().getListeObjet().remove(saCase.getObjet());
                    this.setPointAction(this.getPointAction()-1);
                }
            }

        }
        else
        {
            System.out.println("Pour rammasser : Vous n'avez pas assez de points d'actions ou votre hotte est pleine");
        }


    }

    /**
     * vide la hotte et incrémente le score si dans cuve correspondante seulement
     */
    public void viderHotte()
    {


            if(saCase.getObjet().getType()==Type_Objet.Cuve_Blanc && hotte.getTypeRaisin()==Type_Objet.Blanc)
            {
                score+=((Raisin_Blanc)saCase.getObjet()).getValeurRaisin()*((Raisin_Blanc)saCase.getObjet()).getQte();
                ((Raisin_Blanc)saCase.getObjet()).setQte(0);

            }
            else if(saCase.getObjet().getType()==Type_Objet.Cuve_Rouge && hotte.getTypeRaisin()==Type_Objet.Rouge)
            {
                score+=((Raisin_Rouge)saCase.getObjet()).getValeurRaisin()*((Raisin_Blanc)saCase.getObjet()).getQte();
                ((Raisin_Rouge)saCase.getObjet()).setQte(0);
            }
            else
            {
                if(hotte.getTypeRaisin()==Type_Objet.Blanc)
                {
                    ((Raisin_Blanc)saCase.getObjet()).setQte(0);
                }
                else
                {
                    ((Raisin_Rouge)saCase.getObjet()).setQte(0);
                }
            }

            this.setPointAction(this.getPointAction()-1);



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

    public Hotte getHotte() {return this.hotte; }
}
