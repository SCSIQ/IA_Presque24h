package Case;

import Carte.Map;

public class Chemin extends Case {

    public Chemin(int ligne, int colonne, Map map) {
        super(ligne, colonne, map);
    }

    @Override
    public Type_Case getType() {
        return Type_Case.chemin;
    }

    public boolean franchissable()
    {
        return true;
    }
}
