package Carte.Objet;

import Case.Case;

public class Raisin_Blanc extends Raisin {

    public Raisin_Blanc(Case c, int qte){
        super(c, qte);
    }

    @Override
    public Type_Raisin getType() {
        return Type_Raisin.Blanc;
    }
}
