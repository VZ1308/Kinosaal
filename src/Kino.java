public class Kino {

    // Der Kinosaal als 2D-Array (0 = frei, 1 = belegt)
    private int[][] saal;

    // Konstruktor zur Initialisierung des Kinosaals mit Fehlerbehandlung
    public Kino(int[][] saal) {
        if (saal == null || saal.length == 0 || saal[0].length == 0) {
            throw new IllegalArgumentException("Der Kinosaal darf nicht null oder leer sein.");
        }
        this.saal = saal;
    }

    // Methode zur Berechnung der freien Plätze pro Reihe
    public int[] berechneFreiePlaetzeProReihe() {
        int[] freiePlaetze = new int[saal.length]; // Array für freie Plätze pro Reihe
        for (int i = 0; i < saal.length; i++) {
            int count = 0;
            for (int j = 0; j < saal[i].length; j++) {
                if (saal[i][j] == 0) { // Zählen der freien Plätze (0)
                    count++;
                }
            }
            freiePlaetze[i] = count; // Speichern der Anzahl freier Plätze in der aktuellen Reihe
        }
        return freiePlaetze;
    }

    // Methode zur Berechnung der prozentualen Auslastung des Kinosaals
    public double berechneAuslastung() {
        int totalPlaetze = 0;
        int belegtePlaetze = 0;
        for (int i = 0; i < saal.length; i++) {
            for (int j = 0; j < saal[i].length; j++) {
                totalPlaetze++;
                if (saal[i][j] == 1) { // Zählen der belegten Plätze (1)
                    belegtePlaetze++;
                }
            }
        }
        return ((double) belegtePlaetze / totalPlaetze) * 100; // Berechnung der prozentualen Auslastung
    }

    // Methode zur Ausgabe des Sitzplans und der Statistik
    public void ausgabe() {
        System.out.println("Sitzplan des Kinosaals:");
        for (int i = 0; i < saal.length; i++) {
            for (int j = 0; j < saal[i].length; j++) {
                // Ausgabe eines Symbols für freie (O) oder belegte (X) Plätze
                System.out.print(saal[i][j] == 0 ? "O " : "X ");
            }
            System.out.println(); // Neue Zeile nach jeder Reihe
        }

        // Ausgabe der freien Plätze pro Reihe
        int[] freiePlaetze = berechneFreiePlaetzeProReihe();
        System.out.println();
        for (int i = 0; i < freiePlaetze.length; i++) {
            System.out.println(freiePlaetze[i] + " freie Plätze in Reihe " + (i + 1));
        }
        System.out.println();

        // Ausgabe der prozentualen Auslastung des Kinosaals
        System.out.println("Prozentuale Auslastung des Kinosaals: " + berechneAuslastung() + "%");
    }

    // Hauptmethode
    public static void main(String[] args) {
        try {
            // Beispiel: 0 = frei, 1 = belegt
            int[][] saal = {
                    {0, 1, 0, 1, 0},
                    {1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1},
                    {0, 0, 1, 0, 1}
            };

            // Erstellen einer Kino-Instanz und Ausgabe der Informationen
            Kino kino = new Kino(saal);
            kino.ausgabe();
        } catch (IllegalArgumentException e) {
            System.err.println("Fehler: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
        }
    }
}
