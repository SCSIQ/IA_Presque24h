package Objet;

public class Cuve_Blanc extends Objet {
    @Override
    public boolean ramassable() {
        return false;
    }

    @Override
    public Type_Objet getType() {
        return Type_Objet.Cuve_Blanc;
    }
}
