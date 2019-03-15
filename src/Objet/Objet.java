package Objet;

import Case.Case;

public abstract class Objet {
    private Case saCase;                                                        //Case où se situe l'objet

//---------- CONSTRUCTEURS -----------------------------------------------------

    public Objet() {
        this.saCase = null;
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    //Fixe la case de l'objet
    public void setCase(Case _saCase) {
        this.saCase = _saCase;
        this.saCase.getMap().getListeObjet().add(this);
    }

    //Renvoie la case de l'objet
    public Case getCase() {
        return this.saCase;
    }

//------------------------------------------------------------------------------

    //L'objet est-il ramassable
    public abstract boolean ramassable();
    //Type de l'objet
    public abstract Type_Objet getType();

    //Méthode appelée quand l'objet est ramassé
    public void ramasser() {
        if(this.ramassable()) {
            this.saCase.setObjet(null);
            this.saCase.getMap().getListeObjet().remove(this);
        }
    }
}
