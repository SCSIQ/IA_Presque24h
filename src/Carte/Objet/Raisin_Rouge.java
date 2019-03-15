package Carte.Objet;

import Case.Case;

public class Raisin_Rouge extends Raisin {

    public Raisin_Rouge(Case c, int qte){
        super(c, qte);
    }

    @Override
    public Type_Raisin getType() {
        return Type_Raisin.Rouge;
    }
}
