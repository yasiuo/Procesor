package Szlachetna;

import java.util.ArrayList;

public class FCFS extends Algorytm {


    @Override
    public void przerob(ArrayList<Proces> procesy, ArrayList<Proces> procesy_wykonane, int kwant) {
        posortuj(procesy);
        while (true){
            if (procesy.isEmpty()) break;
            Proces nastepny = procesy.get(0);

            wykonaj(procesy,nastepny,procesy_wykonane);
        }

    }


}
