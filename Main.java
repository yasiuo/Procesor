package Szlachetna;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //for (Proces x : test1) System.out.println(x);

        int czasFCFS = 0;
        int czasSJF = 0;
        int czasRR = 0;
        int czasSRTF = 0;

        int ileSerii = 50;

        for (int i=0;i<ileSerii;i++) {
            ArrayList<Proces> listaProcesow = generator(50);
            ArrayList<Proces> lista1 = kopiarka(listaProcesow);
            ArrayList<Proces> lista2 = kopiarka(listaProcesow);
            ArrayList<Proces> lista3 = kopiarka(listaProcesow);
            ArrayList<Proces> lista4 = kopiarka(listaProcesow);

            //for (Proces x : listaProcesow) System.out.println(x.toString());

            Procesor doFCFS = new Procesor(new FCFS(lista1));
            czasFCFS+=doFCFS.getSredniCzas();

            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            Procesor doSJF = new Procesor(new SJF(lista2));
            czasSJF+=doSJF.getSredniCzas();

            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            Procesor doRR = new Procesor(new RoundRobin(lista3, 25));
            czasRR+=doRR.getSredniCzas();

            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            Procesor doSRTF = new Procesor(new SRTF(lista4));
            czasSRTF+=doSRTF.getSredniCzas();
        }
        System.out.println("Sredni czas FCFS: " + czasFCFS/ileSerii);
        System.out.println("Sredni czas SJF: " + czasSJF/ileSerii);
        System.out.println("Sredni czas RR: " + czasRR/ileSerii);
        System.out.println("Sredni czas SRTF: " + czasSRTF/ileSerii);
    }

    public static ArrayList<Proces> generator(int dlugosc){
        ArrayList<Proces> procesy = new ArrayList<>();
        for (int i =0;i<dlugosc;i++) procesy.add(new Proces(i));
        return procesy;
    }

    public static ArrayList<Proces> kopiarka(ArrayList<Proces> wejscie){
        ArrayList<Proces> wyjscie = new ArrayList<>();
        for (Proces x : wejscie){
            wyjscie.add(new Proces(x.getDlugosc_fazy_proc(),x.getCzas_przybycia(),x.getID()));
        }
        return wyjscie;
    }
}
