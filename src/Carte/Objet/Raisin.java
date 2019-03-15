package Carte.Objet;

import Case.Case;

public abstract class Raisin {

    private int qte;
    private Case c;

    public Raisin(Case _c, int _qte){
        this.c=_c;
        this.qte=_qte;
    }

    public int getQte(){
        return qte;
    }

    public Case getC(){
        return c;
    }

    public abstract void getType();
}
