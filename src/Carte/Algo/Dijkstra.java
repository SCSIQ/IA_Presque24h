package Carte.Algo;

import Carte.Graphes.Couple_Noeud;
import Carte.Graphes.Graphe;
import Carte.Graphes.Noeud;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {
    private Graphe graph;
    private Noeud debut;
    private Noeud fin;
    private HashMap<Noeud,Integer> distance;
    private HashMap<Noeud,Boolean> visited;
    private HashMap<Noeud,Noeud> predecessor;
    private ArrayList<Noeud> path;
    private Integer infini;

    public Dijkstra (Graphe graph){
        this.graph = graph;
        this.distance = new HashMap<Noeud,Integer>();
        this.visited = new HashMap<Noeud,Boolean>();
        this.predecessor = new HashMap<Noeud,Noeud>();
        this.path = new ArrayList<Noeud>();
        this.infini = null;
    }

    public void initialisation(){
        int max = getInfini();
        for (Noeud v : graph.getNoeuds().values()){
            distance.put(v,max);
            visited.put(v,false);
            predecessor.put(v,null);
        }
        distance.put(debut,0);
    }

    public Noeud closestNoeud(){
        int min = getInfini()+1;
        Noeud plusProche = null;
        for (Noeud v : distance.keySet()){
            if (visited.get(v)==false){
                if (distance.get(v)<min){
                    plusProche = v;
                    min = distance.get(v);
                }
            }
        }
        return plusProche;
    }


    public void calcul(Noeud _debut, Noeud _fin){
        this.debut = _debut;
        this.fin = _fin;
        this.initialisation();
        for (int i = 0; i< visited.size(); i++){
            Noeud a = closestNoeud();
            visited.put(a,true);
            for (Noeud b : visited.keySet()){
                relaxing(a,b);
            }
        }
        Noeud v = fin;
        while (v !=null){
            path.add(0,v);
            v = predecessor.get(v);
        }
        path.remove(0);
        //System.out.println(path);
    }

    public void relaxing(Noeud a, Noeud b){
        //System.out.println(this.graph.getLabels().get(new NoeudCouple(a,b)));
        if(this.graph.getLabels().get(new Couple_Noeud(a,b)) != null) {
            if (distance.get(b)> (distance.get(a)+ this.graph.getLabels().get(new Couple_Noeud(a,b)))){
                distance.put(b, (distance.get(a)+ this.graph.getLabels().get(new Couple_Noeud(a,b))));
                predecessor.put(b, a);
            }
        }
    }
    public int getInfini(){
        if(infini == null){
            infini = 0;
            for (Integer vLabel : graph.getLabels().values()){
                infini += vLabel;
            }
            infini++;
        }
        return infini;
    }

    public ArrayList<Noeud> getPath() {
        return path;
    }

    public void destroyFirst(){
        this.path.remove(0);
    }

    public void destroy(){
        this.graph=null;
        this.distance.clear();
        this.visited.clear();
        this.predecessor.clear();
        this.path.clear();
        this.infini = null;
    }

    public int taillePath(Noeud n){
        return distance.get(n);
    }
}
