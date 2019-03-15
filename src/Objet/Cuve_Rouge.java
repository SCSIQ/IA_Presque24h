package Objet;

public class Cuve_Rouge extends Objet {

    @Override
    public boolean ramassable() {
        return false;
    }

    @Override
    public Type_Objet getType() {
        return Type_Objet.Cuve_Rouge;
    }
}
