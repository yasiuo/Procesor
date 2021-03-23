package Szlachetna;

import java.util.ArrayList;

public class SRTF extends Algorytm {

    ArrayList<Integer> czasy = new ArrayList<>();

    public SRTF(ArrayList<Proces> procesy) {
        super(procesy);
    }

    @Override
    public void przerob() {
        posortuj();
        odswiez(procesy.get(0).getCzas_przybycia());
        nowe_czasy();

        while (true) {
            if (procesy.isEmpty()) break;
            label3:
            for (int i = 0; i < czasy.size(); i++) {
                label1:
                for (int j = 0; j < procesy.size(); j++) {
                    if (procesy.get(j).getDlugosc_fazy_proc() == czasy.get(i)) {
                        Proces nastepny = procesy.get(j);
                        if(nastepny.getCzas_przybycia()==0) {
                            {
                                nastepny.zmniejszDlugosc_fazy_proc(1);
                                odswiez(1);
                                nastepny.dodCzas_oczekiwania(-1);
                                if (nastepny.getDlugosc_fazy_proc()==0){
                                    procesy.remove(nastepny);
                                    procesy_wykonane.add(nastepny);
                                }
                                nowe_czasy();
                                break label3;
                            }
                        }
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

    public void nowe_czasy(){
        czasy = new ArrayList<>();
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
    }



}
