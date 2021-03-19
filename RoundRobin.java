package Szlachetna;

import java.util.ArrayList;

public class RoundRobin extends Algorytm {

    @Override
    public void przerob(ArrayList<Proces> procesy, ArrayList<Proces> procesy_wykonane, int kwant) {
        posortuj(procesy);
        odswiez(procesy.get(0).getCzas_przybycia(),procesy);
        label2:
        while (true){
            if (procesy.isEmpty()) break label2;
            for (int i=0;i<procesy.size();i++){
                Proces nastepny = procesy.get(i);
                label:
                for (int j=kwant;j>0;j--){
                    if (nastepny.getCzas_przybycia()>0){
                        break label;
                    }
                    else if (nastepny.getDlugosc_fazy_proc()==0){
                        procesy_wykonane.add(nastepny);
                        procesy.remove(nastepny);
                        break label;
                    }else {
                        nastepny.zmniejszDlugosc_fazy_proc(1);
                        odswiez(1, procesy);
                        nastepny.dodCzas_oczekiwania(-1);
                    }
                }
            }
        }

    }
}
