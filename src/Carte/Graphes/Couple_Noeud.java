package Carte.Graphes;

import java.util.Objects;

public class Couple_Noeud {
    private Noeud start;
    private Noeud end;

    public Couple_Noeud(Noeud _start, Noeud _end){
        this.start=_start;
        this.end=_end;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.start);
        hash = 71 * hash + Objects.hashCode(this.end);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CoupleNoeud other = (CoupleNoeud) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
    }
}
