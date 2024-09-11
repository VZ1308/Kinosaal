public class KinoSaal {
    // 2D Array zur Darstellung des Kinosaals
    private int[][] saal;

    // Konstruktor zur Initialisierung des Saals
    public KinoSaal(int[][] saal) {
        this.saal = saal;
    }

    // Methode zur Berechnung der freien Plätze pro Reihe
    public int[] berechneFreiePlaetzeProReihe() {
        int[] freiePlaetze = new int[saal.length];
        for (int i = 0; i < saal.length; i++) {
            int freie = 0;
            for (int j = 0; j < saal[i].length; j++) {
                if (saal[i][j] == 0) {
                    freie++;
                }
            }
            freiePlaetze[i] = freie;
        }
        return freiePlaetze;
    }

    // Methode zur Berechnung der Gesamtanzahl der Plätze und der belegten Plätze
    public int berechneGesamtPlaetze() {
        int gesamtPlaetze = 0;
        for (int i = 0; i < saal.length; i++) {
            gesamtPlaetze += saal[i].length;
        }
        return gesamtPlaetze;
    }

    public int berechneBelegtePlaetze() {
        int belegtePlaetze = 0;
        for (int i = 0; i < saal.length; i++) {
            for (int j = 0; j < saal[i].length; j++) {
                if (saal[i][j] == 1) {
                    belegtePlaetze++;
                }
            }
        }
        return belegtePlaetze;
    }

    // Methode zur Berechnung der prozentualen Auslastung
    public double berechneAuslastung() {
        int gesamtPlaetze = berechneGesamtPlaetze();
        int belegtePlaetze = berechneBelegtePlaetze();
        return ((double) belegtePlaetze / gesamtPlaetze) * 100;
    }

    // Methode zur Ausgabe der freien Plätze pro Reihe und der Auslastung
    public void ausgabe() {
        int[] freiePlaetze = berechneFreiePlaetzeProReihe();
        for (int i = 0; i < freiePlaetze.length; i++) {
            System.out.println(freiePlaetze[i] + " freie Plätze in Reihe " + (i + 1));
        }
        System.out.println("Prozentuale Auslastung des Kinosaals: " + berechneAuslastung() + "%");

    }

    public static void main(String[] args) {
        // Beispiel: 0 = frei, 1 = belegt
        int[][] saal = {
                {0, 1, 0, 1, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1}
        };

        KinoSaal kinoSaal = new KinoSaal(saal);
        kinoSaal.ausgabe();
    }
}
