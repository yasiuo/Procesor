package Szlachetna;

import java.util.ArrayList;

public abstract class Algorytm {

    public abstract void przerob(ArrayList<Proces> procesy, ArrayList<Proces> procesy_wykonane, int kwant);

    public void odswiez (int czas, ArrayList<Proces> procesy) {
        for (Proces x : procesy) {
            if (x.getCzas_przybycia() > 0) {
                label:
                for (int czas2= czas; czas2 > 0; czas2--) {
                    if (x.getCzas_przybycia() == 0) {
                        x.dodCzas_oczekiwania(czas2);
                        break label;
                    }
                    x.zmniejszCzas_przybycia(1);
                }
            }
            else x.dodCzas_oczekiwania(czas);
        }
    }
    public void posortuj(ArrayList<Proces> procesy){
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

    public void wykonaj(ArrayList<Proces> procesy,Proces nastepny,ArrayList<Proces> procesy_wykonane){
        if (nastepny.getCzas_przybycia()>0) {
            odswiez(nastepny.getCzas_przybycia(), procesy);
        }

        odswiez(nastepny.getDlugosc_fazy_proc(),procesy);
        nastepny.dodCzas_oczekiwania(-nastepny.getDlugosc_fazy_proc());
        procesy.remove(nastepny);
        procesy_wykonane.add(nastepny);
    }
}
