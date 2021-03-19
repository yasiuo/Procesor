package Szlachetna;

import java.util.Random;

public class Proces {
    int czas_oczekiwania;
    int dlugosc_fazy_proc;
    int czas_przybycia;
    int ID;

    @Override
    public String toString() {
        return "Proces{" +
                "czas_oczekiwania=" + czas_oczekiwania +
                ", dlugosc_fazy_proc=" + dlugosc_fazy_proc +
                ", czas_przybycia=" + czas_przybycia +
                ", ID=" + ID +
                '}';
    }

    public Proces(int ID) {
        Random random = new Random();
        this.czas_oczekiwania = 0;
        this.dlugosc_fazy_proc = random.nextInt(100);
        this.ID = ID;
        this.czas_przybycia=random.nextInt(50)+ID*random.nextInt(2);
    }

    public Proces( int dlugosc_fazy_proc, int czas_przybycia, int ID) {
        this.czas_oczekiwania = 0;
        this.dlugosc_fazy_proc = dlugosc_fazy_proc;
        this.czas_przybycia = czas_przybycia;
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

    public void zmniejszDlugosc_fazy_proc(int kwant) {
        this.dlugosc_fazy_proc -= kwant;
    }

    public int getCzas_przybycia() {
        return czas_przybycia;
    }

    public void zmniejszCzas_przybycia(int czas) {
        this.czas_przybycia -= czas;
    }

    public int getID() {
        return ID;
    }
}
