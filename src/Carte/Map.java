package Carte;

import Carte.Graphes.Graphe;
import Objet.Objet;
import Joueur.Joueur;
import Carte.Parseur.Fabrique_Cases;
import Case.Case;
import Case.Type_Case;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {


    private final HashMap<Coordonnees,Case> hashMapCases;                       //Stockage par coordonnées des cases
    private final ArrayList<Case> listeCase;                                    //Liste des cases
    private final ArrayList<Objet> listeObjet;                                  //Liste des objets     //Position de la sortie
    private Joueur joueur;        //Cadence
    private Graphe graphe_simple;

//---------- CONSTRUCTEURS -----------------------------------------------------

    public Map() {
        //Initialisation
        this.hashMapCases = new HashMap<>();
        this.listeCase = new ArrayList<>();
        this.listeObjet = new ArrayList<>();
        this.joueur = null;
        this.graphe_simple=new Graphe();
    }

//---------- GETEUR/SETEUR -----------------------------------------------------


    public ArrayList<Objet> getListeObjet() {
        return listeObjet;
    }

    //Renvoie la case présente à ses coordonnées
    public Case getCase(int ligne, int colonne) {
        return this.hashMapCases.get(new Coordonnees(ligne,colonne));
    }

    //Change la case à ses coordonnées
    public void setCase(int ligne, int colonne, Case _case) {
        this.hashMapCases.put(new Coordonnees(ligne,colonne), _case);
        this.listeCase.add(_case);
    }

    //Change le type de case à ses coordonnées (lors du minage)
    public void changeTypeCase(Case caseInitiale, Type_Case typeNouvelleCase) {
        Case nouvelleCase = Fabrique_Cases.construireCase(typeNouvelleCase, caseInitiale.getLigne(), caseInitiale.getColonne(), this);
        this.setCase(caseInitiale.getLigne(), caseInitiale.getColonne(), nouvelleCase);
        this.listeCase.remove(caseInitiale);

        if (this.graphe_simple!=null){
            this.graphe_simple.replaceCase(caseInitiale, nouvelleCase);
        }
    }

    //Fixe le joueur
    public void setJoueur(Joueur _joueur) {
        this.joueur = _joueur;
    }

    //Renvoie la hashmap des cases
    public HashMap<Coordonnees,Case> getHashMapCases() {
        return this.hashMapCases;
    }

    //Renvoie la liste des cases
    public ArrayList<Case> getListeCase() {
        return this.listeCase;
    }


    //Renvoie le graphe simple
    public Graphe getGrapheSimple(){
        return this.graphe_simple;
    }



    private void genererGrapheSimple(){
        //Génération des sommets
        for (Case c : this.listeCase){
            this.graphe_simple.addNoeud(c);
        }
        //Génération des edges
        for (Case c1 : this.listeCase){
            for (Case c2 : this.listeCase){
                if ((Math.abs(c1.getLigne()-c2.getLigne())+Math.abs(c1.getColonne()-c2.getColonne()))==1){
                    switch (c2.getType())
                    {
                        /*case Sol:
                            this.graphe_simple.addEdge(c1, c2);
                            this.graphe_simple.setLabel(c1,c2,1);
                            break;
                        case Mur:
                            this.graphe_simple.addEdge(c1, c2);
                            this.graphe_simple.setLabel(c1,c2,2);
                            break;
                        default :
                            //System.out.println("Bruh");
                            break;*/
                    }
                }
            }
        }

    }

    public String toString() {
        String toReturn = "";
        for(Case c : this.listeCase) {
            toReturn += c.toString()+"\n";
        }
        return toReturn;
    }

}

