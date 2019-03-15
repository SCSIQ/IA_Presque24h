package Carte.Graphes;

public class Noeud {
    private Graphe graph;
    private ArrayList<Noeud> voisins;
    private Case c;

    public Noeud(Graphe graph, Case c){
        this.graph=graph;
        this.voisins=new ArrayList();
        this.c=c;
    }
    public ArrayList<Noeud> getVoisins(){
        return this.voisins;
    }
    public void setVoisin(Noeud n){
        this.voisins.add(n);
    }
    public Case getCase(){
        return c;
    }

    public void setC(Case c) {
        this.c = c;
    }

    @Override
    public String toString(){
        return "["+this.c.getLigne()+","+this.c.getColonne()+"]";
    }
}
