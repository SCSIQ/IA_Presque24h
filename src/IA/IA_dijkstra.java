package IA;

import Carte.Algo.Astar;
import Carte.Algo.Dijkstra;
import Carte.Graphes.Graphe;
import Carte.Graphes.Noeud;
import Carte.Map;
import Case.Case;
import Joueur.Joueur;
import Objet.Objet;
import Objet.Type_Objet;
import Case.Type_Case;

import java.util.ArrayList;

public class IA_dijkstra extends IA{

    private Dijkstra dijkstra;
    private Graphe graphe;
    private Map map;
    private Type_Objet couleur;
    private Astar astar;
    private ArrayList<Noeud> cheminAller;

    private boolean aRaisin = false;

    public IA_dijkstra(Joueur _entite) {
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



            System.out.println("salow");
            /*if(this.getCase().getObjet()!=null){
                //Si l'objet de la case est du raisin
                System.out.println("objet!=null");
                if(this.getCase().getObjet().getType()==Type_Objet.Rouge || this.getCase().getObjet().getType()==Type_Objet.Blanc){
                    System.out.println("coucou");
                    action=Type_Action.ramasser;
                    this.getEntite().ramasser();
                }
                //Si on est sur une cuve et que le type de la cuve est le meme que les raisin de la hotte
                if((this.getCase().getObjet().getType()==Type_Objet.Cuve_Blanc && this.getEntite().getHotte().getTypeRaisin()==Type_Objet.Cuve_Blanc) || (this.getCase().getObjet().getType()==Type_Objet.Cuve_Rouge && this.getEntite().getHotte().getTypeRaisin()==Type_Objet.Cuve_Rouge)){
                    action=Type_Action.vider;
                    this.getEntite().viderHotte();
                }
            }*/
            System.out.println(this.getCase().getObjet());
            if(this.getCase().getObjet()!=null) {

                if (this.getCase().getObjet().getType() != Type_Objet.Cuve_Rouge && this.getCase().getObjet().getType() != Type_Objet.Cuve_Blanc) {
                    System.out.println("coucou");
                    action = Type_Action.ramasser;
                    //this.aRaisin = true;
                    this.getEntite().ramasser();
                    this.couleur=this.getEntite().getHotte().getTypeRaisin();
                }
            }
            System.out.println(action);
            this.calcDest();
        }
        else{
            
            action = calculAction(astar.getPath().get(0).getCase());
            switch(action){
                case deplacement_haut: this.getEntite().setCase(this.getEntite().getSaCase().getHaut());break;
                case deplacement_bas: this.getEntite().setCase(this.getEntite().getSaCase().getBas());break;
                case deplacement_gauche: this.getEntite().setCase(this.getEntite().getSaCase().getGauche());break;
                case deplacement_droite: this.getEntite().setCase(this.getEntite().getSaCase().getDroite());break;
            }
            /*if(aRaisin==true){
                Case casecuveB;
                Case casecuveR;
                for(Objet o : getMap().getListeObjet())
                {
                    if(o.getType()==Type_Objet.Cuve_Rouge){
                        casecuveB=o.getCase();
                    }
                    else if(o.getType()==Type_Objet.Cuve_Blanc){
                        casecuveR=o.getCase();
                    }
                    action = calculAction(astar.getPath().get(0).getCase());
                }
            }*/

            //System.out.println(astar.getPath().get(0).getCase().toString());
            astar.destroyFirst();
            //System.out.println(action);

        }
        return action;
    }

    public void calcDest(){
        Case dest = this.getCase();
        int dist = 1000;
        this.dijkstra=new Dijkstra(this.graphe);
        this.dijkstra.calcul(graphe.getNoeud(this.getCase()),graphe.getNoeud(this.getCase()));
        if(this.couleur==null) {
            for (Objet o : map.getListeObjet()) {
                if (o.getType() == Type_Objet.Blanc || o.getType() == Type_Objet.Rouge) {
                    int distObjet = (int) Math.sqrt(Math.pow((double) o.getCase().getLigne() - (double) this.getCase().getLigne(), 2) + Math.pow((double) o.getCase().getColonne() - (double) this.getCase().getColonne(), 2));
                    if (dist > distObjet) {
                        dist=distObjet;
                        dest = o.getCase();
                    }
                }
            }

        }
        else{
            for (Objet o : map.getListeObjet()) {



                if (o.getType() == this.couleur) {
                    int distObjet = (int) Math.sqrt(Math.pow((double) o.getCase().getLigne() - (double) this.getCase().getLigne(), 2) + Math.pow((double) o.getCase().getColonne() - (double) this.getCase().getColonne(), 2));
                    if (dist > distObjet) {
                        dist=distObjet;
                        dest = o.getCase();
                    }
                }

              /*  if(aRaisin){
                    Case casecuve = null;
                    for(Objet o2 : getMap().getListeObjet())
                    {
                        if(o2.getType()==Type_Objet.Cuve_Rouge){
                            casecuve=o.getCase();
                        }
                        else if(o2.getType()==Type_Objet.Cuve_Blanc){
                            casecuve=o.getCase();
                        }
                    }
                    dest=casecuve;
                    System.out.println("------------------------------------------> "+dest.toString());
                }*/
            }

        }

        astar.calcul(this.graphe.getNoeud(this.getCase()),this.graphe.getNoeud(dest));
        cheminAller=astar.getPath();
        //System.out.println("dest"+dest.toString());
        //System.out.println("case joueur"+this.getCase().toString());
    }

    public Type_Action calculAction(Case CaseSuivante){
        Type_Action res = Type_Action.attendre;
        //Si la case est un chemin
        if(CaseSuivante.getType()==Type_Case.chemin){
            //Si la case est vide
            if(CaseSuivante.getJoueur()==null) {
                res = this.directionDeplacement(this.getCase().getLigne(), this.getCase().getColonne(), CaseSuivante);
            }
        }
        return res;
    }
}
