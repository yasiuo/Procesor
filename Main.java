package Szlachetna;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //for (Proces x : test1) System.out.println(x);

        int czasFCFS = 0;
        int czasSJF = 0;
        int czasRR = 0;

        int ileSerii = 50;

        for (int i=0;i<ileSerii;i++) {
            ArrayList<Proces> test1 = generator(50);
            Procesor doFCFS = new Procesor(new ArrayList<>(test1), new FCFS(), 0);
            Procesor doSJF = new Procesor(new ArrayList<>(test1), new SJF(), 0);

            Procesor doRR = new Procesor(new ArrayList<>(test1), new RoundRobin(), 5);

            czasFCFS+=doFCFS.getSredniCzas();
            czasSJF+=doSJF.getSredniCzas();
            czasRR+=doRR.getSredniCzas();
        }
        System.out.println("Sredni czas FCFS: " + czasFCFS/ileSerii);
        System.out.println("Sredni czas SJF: " + czasSJF/ileSerii);
        System.out.println("Sredni czas RR: " + czasRR/ileSerii);
    }

    public static ArrayList<Proces> generator(int dlugosc){
        ArrayList<Proces> procesy = new ArrayList<>();
        for (int i =0;i<dlugosc;i++) procesy.add(new Proces(i));
        return procesy;
    }
}
