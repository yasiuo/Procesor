package Szlachetna;

import java.util.ArrayList;

public class Procesor {
    ArrayList<Proces> procesy;
    ArrayList<Proces> procesy_wykonane;
    Algorytm algorytm;

    public Procesor(ArrayList<Proces> procesy, Algorytm algorytm) {
        this.procesy = procesy;
        this.algorytm = algorytm;
        this.procesy_wykonane = new ArrayList<>();
        wykonaj_wszystko();
    }

    public void wykonaj_wszystko(){
        while (procesy.size()!=0) {
            Proces nastepny = algorytm.nastepny(procesy);
            procesy.remove(nastepny);
            procesy_wykonane.add(nastepny);
            odswiez(nastepny.getDlugosc_fazy_proc());
            //wyswietl();
        }
        wyswietlSredniCzas();
    }

    public void odswiez(int czas){
        for (Proces x : procesy){
            x.dodCzas_oczekiwania(czas);
        }
    }

    public void wyswietl(){
        System.out.println("kolejka:");
        for (Proces x : procesy) System.out.println(x.toString());
        System.out.println("wykonane:");
        for (Proces x : procesy_wykonane) System.out.println(x.toString());
    }

    public void wyswietlSredniCzas(){
        int czas=0;
        int licz=0;

        for (Proces x : procesy_wykonane){
            czas += x.getCzas_oczekiwania();
            licz++;
        }
        System.out.println("Sredni czas oczekiwania dla "+algorytm.getClass().getSimpleName() +" wynosi: " + czas/licz);
    }
}
