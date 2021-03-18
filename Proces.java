package Szlachetna;

import java.util.Random;

public class Proces {
    int czas_oczekiwania;
    int dlugosc_fazy_proc;
    int ID;

    @Override
    public String toString() {
        return "Proces{" +
                "czas_oczekiwania=" + czas_oczekiwania +
                ", dlugosc_fazy_proc=" + dlugosc_fazy_proc +
                ", ID=" + ID +
                '}';
    }

    public Proces(int ID) {
        Random random = new Random();
        this.czas_oczekiwania = 0;
        this.dlugosc_fazy_proc = random.nextInt(100);
        this.ID = ID;
    }

    public void dodCzas_oczekiwania(int czas_oczekiwania) {
        this.czas_oczekiwania += czas_oczekiwania;
    }

    public int getDlugosc_fazy_proc() {
        return dlugosc_fazy_proc;
    }

    public int getCzas_oczekiwania() {
        return czas_oczekiwania;
    }
}
