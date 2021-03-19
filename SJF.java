package Szlachetna;

import java.util.ArrayList;

public class SJF extends Algorytm {

    @Override
    public void przerob(ArrayList<Proces> procesy, ArrayList<Proces> procesy_wykonane, int kwant) {
        posortuj(procesy);
        Proces nastepny = procesy.get(0);
        wykonaj(procesy,nastepny,procesy_wykonane);

        ArrayList<Integer> czasy = new ArrayList<>();
        for (Proces x : procesy){
            czasy.add(x.getDlugosc_fazy_proc());
        }
        boolean t = true;
        while (t) {
            t = false;
            for (int i = 1; i < czasy.size(); i++) {
                int lx = czasy.get(i);
                int ly = czasy.get(i-1);
                if (czasy.get(i) < czasy.get(i - 1)){
                    czasy.set(i-1, lx);
                    czasy.set(i,ly);
                    t=true;
                }
            }
        }
        while (true) {
            if (procesy.isEmpty()) break;
            label:
            for (int i = 0; i < czasy.size(); i++) {
                for (int j = 0; j < procesy.size(); j++) {
                    if (procesy.get(j).getDlugosc_fazy_proc() == czasy.get(i)) {
                        nastepny = procesy.get(j);
                        break label;
                    }
                }
            }
            wykonaj(procesy, nastepny, procesy_wykonane);
        }
    }

}
