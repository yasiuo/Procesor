package Szlachetna;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Proces> test1 = generator(50);
        //for (Proces x : test1) System.out.println(x);

        Procesor doFCFS = new Procesor(new ArrayList<>(test1), new FCFS());
        Procesor doSJF = new Procesor(new ArrayList<>(test1), new SJF());
    }

    public static ArrayList<Proces> generator(int dlugosc){
        ArrayList<Proces> procesy = new ArrayList<>();
        for (int i =0;i<dlugosc;i++) procesy.add(new Proces(i));
        return procesy;
    }
}
