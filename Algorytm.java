package Szlachetna;

import java.util.ArrayList;

public abstract class Algorytm {
    ArrayList<Proces> procesy;
    ArrayList<Proces> procesy_wykonane;

    public Algorytm(ArrayList<Proces> procesy) {
        this.procesy = procesy;
        this.procesy_wykonane = new ArrayList<>();
    }

    public abstract void przerob();

    public void odswiez (int czas) {
        for (Proces x : procesy) {
            if (x.getCzas_przybycia() > 0) {
                label:
                for (int czas2= czas; czas2 > 0; czas2--) {
                    if (x.getCzas_przybycia() == 0) {
                        x.dodCzas_oczekiwania(czas2);
                        break label;
                    }
                    else x.zmniejszCzas_przybycia(1);
                }
            }
            else x.dodCzas_oczekiwania(czas);
        }
    }
    public void posortuj(){
        boolean t = true;
        while (t) {
            t = false;
            for (int i = 1; i < procesy.size(); i++) {
                Proces p1 = procesy.get(i - 1);
                Proces p2 = procesy.get(i);
                if (procesy.get(i).getCzas_przybycia() < procesy.get(i - 1).getCzas_przybycia()) {
                    procesy.set(i, p1);
                    procesy.set(i - 1, p2);
                    t=true;
                }
            }
        }
    }

    public void wykonaj(Proces nastepny){
        if (nastepny.getCzas_przybycia()>0) {
            odswiez(nastepny.getCzas_przybycia());
        }

        odswiez(nastepny.getDlugosc_fazy_proc());
        nastepny.dodCzas_oczekiwania(-nastepny.getDlugosc_fazy_proc());
        procesy.remove(nastepny);
        procesy_wykonane.add(nastepny);
    }

    public ArrayList<Proces> getProcesy_wykonane() {
        return procesy_wykonane;
    }
}
