package Szlachetna;

import java.util.ArrayList;

public class FCFS extends Algorytm {


    public FCFS(ArrayList<Proces> procesy) {
        super(procesy);
    }

    @Override
    public void przerob() {
        posortuj();
        while (true){
            if (procesy.isEmpty()) break;
            Proces nastepny = procesy.get(0);

            wykonaj(nastepny);
        }

    }


}
