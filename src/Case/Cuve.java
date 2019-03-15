package Case;

import Carte.Map;

public class Cuve extends Case {

    public Cuve(int ligne, int colonne, Map map) {
        super(ligne, colonne, map);
    }

    @Override
    public Type_Case getType() {
        return Type_Case.cuve;
    }

    public boolean franchissable()
    {
        return true;
    }
}
