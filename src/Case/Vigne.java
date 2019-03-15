package Case;

import Carte.Map;

public class Vigne extends Case {


    public Vigne(int ligne, int colonne, Map map) {
        super(ligne, colonne, map);
    }

    @Override
    public Type_Case getType() {
        return Type_Case.vigne;
    }

    public boolean franchissable()
    {
        return false;
    }
}
