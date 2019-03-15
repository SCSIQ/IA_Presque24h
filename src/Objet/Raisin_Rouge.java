package Objet;

import Case.Case;

public class Raisin_Rouge extends Objet {

    private int valeurRaisin=20;
    private int qte;

    public Raisin_Rouge(Case c, int qte){
        super();
        this.setCase(c);
        this.qte=qte;
        this.getCase().setObjet(this);
    }

    @Override
    public boolean ramassable() {
        return true;
    }

    @Override
    public Type_Objet getType() {
        return Type_Objet.Rouge;
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
