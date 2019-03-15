package Joueur;

import Carte.Objet.Type_Raisin;

public class Hotte {

    //ATTRIBUTS
    private int nombreRaisin;
    private int quantiteMax;
    private Type_Raisin typeRaisin;

    //CONSTRUCTEUR
    public Hotte()
    {
        nombreRaisin=0;
        quantiteMax=100;
    }

    /*METHODES*/

    /**
     *
     * @return true si la hotte est pleine
     */
    public boolean estPleine()
    {
        boolean res=false;

        if(nombreRaisin==quantiteMax)
        {
            res =true;
        }

        return true;
    }

    //GETTER SETTER
    public int getNombreRaisin() {
        return nombreRaisin;
    }

    public void setNombreRaisin(int nombreRaisin) {
        this.nombreRaisin = nombreRaisin;
    }

    public Type_Raisin getTypeRaisin() {
        return typeRaisin;
    }

    public void setTypeRaisin(Type_Raisin typeRaisin) {
        this.typeRaisin = typeRaisin;
    }

}
