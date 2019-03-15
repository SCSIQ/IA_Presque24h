package IA;

import Carte.Algo.Dijkstra;
import Case.Case;
import Joueur.Joueur;

public class IA_dijkstra extends IA{

    private Dijkstra dijkstra;

    public IA_dijkstra(Joueur _entite) {
        super(_entite);
    }

    @Override
    public Type_Action action() {
        return null;
    }

    public void calcDest(){
        Case dest = this.getCase();
        
    }
}
