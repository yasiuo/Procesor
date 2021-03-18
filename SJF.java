package Szlachetna;

import java.util.ArrayList;

public class SJF extends Algorytm {
    @Override
    public Proces nastepny(ArrayList<Proces> list) {
        ArrayList<Integer> czasy = new ArrayList<Integer>();
        for (Proces x : list){
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
        for (Proces x : list){
            if (x.getDlugosc_fazy_proc()==czasy.get(0)) return x;
        }
        return null;
    }

    @Override
    public Boolean czyZawlaszcza() {
        return false;
    }
}
