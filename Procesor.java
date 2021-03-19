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

        algorytm.przerob(procesy,procesy_wykonane,kwant);
        SredniCzas();
        //wyswietlSredniCzas();
    }

//
//    public void wykonaj_wszystkoZZ() {
//        while (!procesy.isEmpty()) {
//            Iterator<Proces> it = procesy.iterator();
//            boolean test = true;
//
//            while (it.hasNext()){
//                Proces nastepny = it.next();
//                if (nastepny.getCzas_przybycia()<=0) {
//                    test = false;
//                    label1:
//                    for (int i = kwant; i>0;i--) {
//                        odswiez(1);
//                        nastepny.dodCzas_oczekiwania(-1);
//                        nastepny.zmniejszDlugosc_fazy_proc(1);
//                        //System.out.println("w");
//                        if (nastepny.getDlugosc_fazy_proc()<=0){
//                            procesy_wykonane.add(nastepny);
//                            it.remove();
//                            break label1;
//                        }
//                    }
//                }
//            }
//            wyswietl();
//            if (test)
//            odswiez(1);
//        }
//        SredniCzas();
//        //wyswietlSredniCzas();
//    }


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
