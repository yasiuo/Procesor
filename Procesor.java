package Szlachetna;

import java.util.ArrayList;

public class Procesor {
    ArrayList<Proces> procesy;
    ArrayList<Proces> procesy_wykonane;
    Algorytm algorytm;
    int kwant;
    int czas_Sredni;

    public Procesor(ArrayList<Proces> procesy, Algorytm algorytm, int kwant) {
        this.procesy = procesy;
        this.algorytm = algorytm;
        this.procesy_wykonane = new ArrayList<>();
        this.kwant=kwant;
        if (!algorytm.czyZawlaszcza()) wykonaj_wszystkoBZ();
        else wykonaj_wszystkoZZ();
    }

    public void wykonaj_wszystkoBZ(){
        while (procesy.size()!=0) {
            Proces nastepny = algorytm.nastepny(procesy);
            procesy.remove(nastepny);
            procesy_wykonane.add(nastepny);
            odswiez(nastepny.getDlugosc_fazy_proc());
            //wyswietl();
        }
        SredniCzas();
        //wyswietlSredniCzas();
    }

    public void wykonaj_wszystkoZZ() {
        while (procesy.size() != 0) {
            for (int i = 0; i < procesy.size(); i++) {
                Proces nastepny = procesy.get(i);
                odswiez(kwant);
                nastepny.zmniejszDlugosc_fazy_proc(kwant);
                nastepny.dodCzas_oczekiwania(-1*kwant);
                if (nastepny.getDlugosc_fazy_proc()<0) {
                    procesy_wykonane.add(nastepny);
                    procesy.remove(nastepny);
                }
                //wyswietl();
            }
        }
        SredniCzas();
    }

        public void odswiez ( int czas){
            for (Proces x : procesy) {
                x.dodCzas_oczekiwania(czas);
            }
        }

        public void wyswietl () {
            System.out.println("kolejka:");
            for (Proces x : procesy) System.out.println(x.toString());
            System.out.println("wykonane:");
            for (Proces x : procesy_wykonane) System.out.println(x.toString());
        }

        public void wyswietlSredniCzas () {
            System.out.println("Sredni czas oczekiwania dla " + algorytm.getClass().getSimpleName() + " wynosi: " + czas_Sredni);
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
