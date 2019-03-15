package IA;

import Carte.Algo.Astar;
import Carte.Algo.Dijkstra;
import Carte.Graphes.Graphe;
import Carte.Map;
import Case.Case;
import Joueur.Joueur;
import Objet.Type_Objet;

public class IA_MoinsBete extends IA {
    private Dijkstra dijkstra;
    private Graphe graphe;
    private Map map;
    private Type_Objet couleur;
    private Astar astar;

    private int perimetre = 5;

    public IA_MoinsBete(Joueur _entite) {
        super(_entite);
        this.dijkstra=null;
        this.couleur=null;
        this.graphe=null;
        this.map=null;
        this.astar=null;
    }

    @Override
    public Type_Action action() {
        Type_Action action = Type_Action.attendre;

        this.map=this.getEntite().getSaCase().getMap();
        this.graphe=this.map.getGrapheSimple();
        if(astar==null){
            astar = new Astar(graphe);
        }
        if(astar.getPath().isEmpty()){
            if(this.getCase().getObjet()!=null){
                //Si l'objet de la case est du raisin
                if(this.getCase().getObjet().getType()==Type_Objet.Rouge || this.getCase().getObjet().getType()==Type_Objet.Blanc){
                    action=Type_Action.ramasser;
                    this.getEntite().ramasser();
                }
                //Si on est sur une cuve et que le type de la cuve est le meme que les raisin de la hotte
                if((this.getCase().getObjet().getType()==Type_Objet.Cuve_Blanc && this.getEntite().getHotte().getTypeRaisin()==Type_Objet.Cuve_Blanc) || (this.getCase().getObjet().getType()==Type_Objet.Cuve_Rouge && this.getEntite().getHotte().getTypeRaisin()==Type_Objet.Cuve_Rouge)){
                    action=Type_Action.vider;
                    this.getEntite().viderHotte();
                }
            }
            this.calcDest();
        }
        else{
            action = calculAction(astar.getPath().get(0).getCase());
        }
        return action;
    }

    public void calcDest(){
        Case dest = this.getCase();
        int dist = 1000;
        this.dijkstra=new Dijkstra(this.graphe);
        this.dijkstra.calcul(graphe.getNoeud(this.getCase()),graphe.getNoeud(this.getCase()));
    }

    private Type_Action calculAction(Case aCase) {
        Type_Action res = Type_Action.attendre;

        return res;
    }

}
