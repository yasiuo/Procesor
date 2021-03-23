package Szlachetna;

import java.util.ArrayList;

public class SJF extends Algorytm {


    public SJF(ArrayList<Proces> procesy, int kwant) {
        super(procesy, kwant);
    }

    @Override
    public void przerob() {
        posortuj();
        Proces nastepny = procesy.get(0);
        wykonaj(nastepny);

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
            for (int i = 0; i < czasy.size(); i++) {
                label1:
                for (int j = 0; j < procesy.size(); j++) {
                    if (procesy.get(j).getDlugosc_fazy_proc() == czasy.get(i)) {
                        nastepny = procesy.get(j);
                        if(nastepny.getCzas_przybycia()==0) wykonaj(nastepny);
                        else break label1;
                    }
                }
            }
            test:
            while (true) {
                if (procesy.isEmpty()) break test;
                for (Proces x : procesy) {
                    if (x.getCzas_przybycia() == 0) break test;
                }
                odswiez(1);
            }
        }
    }

}
