package Joueur;

public class Hotte {

    //ATTRIBUTS
    private int nombreRaisin;
    private int quantiteMax;
    //private TypeRaisin typeRaisin;

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

}
