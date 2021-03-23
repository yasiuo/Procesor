package Szlachetna;

import java.util.ArrayList;

public class RoundRobin extends Algorytm {
    int kwant;

    public RoundRobin(ArrayList<Proces> procesy, int kwant) {
        super(procesy);
        this.kwant = kwant;
    }


    @Override
    public void przerob() {
        posortuj();
        odswiez(procesy.get(0).getCzas_przybycia());
        label2:
        while (true){
            if (procesy.isEmpty()) break label2;
            label:
            for (int i=0;i<procesy.size();i++){
                Proces nastepny = procesy.get(i);
                label3:
                for (int j=kwant;j>0;j--){
                    if (nastepny.getCzas_przybycia()>0){
                        break label;
                    } else {
                        nastepny.zmniejszDlugosc_fazy_proc(1);
                        odswiez(1);
                        nastepny.dodCzas_oczekiwania(-1);
                        if (nastepny.getDlugosc_fazy_proc()==0) {
                            procesy_wykonane.add(nastepny);
                            procesy.remove(nastepny);
                            break label3;
                        }
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
