package Objet;

import Case.Case;

public class Raisin_Blanc extends Objet {

    private int valeurRaisin=15;
    private int qte;

    public Raisin_Blanc(Case c, int qte){
        super();
        this.qte=qte;
        this.getCase().setObjet(this);
    }

    @Override
    public boolean ramassable() {
        return true;
    }

    @Override
    public Type_Objet getType() {
        return Type_Objet.Blanc;
    }

    public int getQte() {
        return qte;
    }
    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getValeurRaisin() {
        return valeurRaisin;
    }

}
