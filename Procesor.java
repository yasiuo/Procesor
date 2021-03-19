package Szlachetna;

import java.util.ArrayList;
import java.util.Iterator;

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
        while (procesy.size()>0) {
            Proces nastepny = algorytm.nastepny(procesy);
            boolean test = true;
            while (test) {
                ArrayList<Proces> ucieta = new ArrayList<>(procesy);
                labeL:
                while (nastepny.getCzas_przybycia() > 0) {
                    ucieta.remove(nastepny);
                    if (ucieta.size() == 0) {
                        odswiez(1);
                        break labeL;
                    }
                    nastepny = algorytm.nastepny(ucieta);
                }
                test = false;
            }
            if (nastepny.getCzas_przybycia()<=0) {
                this.procesy.remove(nastepny);
                procesy_wykonane.add(nastepny);
                odswiez(nastepny.getDlugosc_fazy_proc());
            }
            //wyswietl();
        }
        SredniCzas();
        //wyswietlSredniCzas();
    }

    public void wykonaj_wszystkoZZ() {
        while (!procesy.isEmpty()) {
            Iterator<Proces> it = procesy.iterator();
            boolean test = true;

            while (it.hasNext()){
                Proces nastepny = it.next();
                if (nastepny.getCzas_przybycia()<=0) {
                    test = false;
                    label1:
                    for (int i = kwant; i>0;i--) {
                        odswiez(1);
                        nastepny.dodCzas_oczekiwania(-1);
                        nastepny.zmniejszDlugosc_fazy_proc(1);
                        if (nastepny.getDlugosc_fazy_proc()<=0){
                            procesy_wykonane.add(nastepny);
                            it.remove();
                            break label1;
                        }
                    }
                }
            }
            wyswietl();
            if (test)
            odswiez(1);
        }
        SredniCzas();
        //wyswietlSredniCzas();
    }

        public void odswiez ( int czas){
        for (Proces x : procesy) {
            if (x.getCzas_przybycia()>0)
                x.zmniejszCzas_przybycia(czas);
            else x.dodCzas_oczekiwania(czas);
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
