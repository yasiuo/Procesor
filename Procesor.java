package Szlachetna;

import java.util.ArrayList;

public class Procesor {
    ArrayList<Proces> procesy_wykonane;
    Algorytm algorytm;
    int czas_Sredni;

    public Procesor(Algorytm algorytm) {
        this.algorytm = algorytm;

        algorytm.przerob();
        this.procesy_wykonane = algorytm.getProcesy_wykonane();
        SredniCzas();
        //for (Proces x : procesy_wykonane) System.out.println(x.getCzas_oczekiwania());
    }


        public void SredniCzas () {
            int czas = 0;
            int licz = 0;

            for (Proces x : procesy_wykonane) {
                czas += x.getCzas_oczekiwania();
                licz++;
            }
            czas_Sredni = czas / licz;
        }

        public int getSredniCzas () {
            return czas_Sredni;
        }
}
