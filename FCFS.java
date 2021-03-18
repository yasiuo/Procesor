package Szlachetna;

import java.util.ArrayList;

public class FCFS extends Algorytm {

    @Override
    public Proces nastepny(ArrayList<Proces> list) {
        Proces nastepny = list.get(0);
        return nastepny;
    }
}
