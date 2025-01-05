import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Czat {
    public void funckja1() {
        UserInput();
    }

    private void UserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile kostek chcesz rzucić? (3 - 10)");
        int wybor = scanner.nextInt();

        if (wybor >= 3 && wybor <= 10) {
            WynikLosowania(wybor);
        } else {
            System.out.println("Podano złą ilość rzutów kostką. Wybierz liczbę z zakresu 3-10.");
        }
    }

    private void WynikLosowania(int liczbaKostek) {
        Random random = new Random();
        Map<Integer, Integer> licznik = new HashMap<>();  // Map do zliczania liczby powtórzeń

        // Rzuty kostkami
        for (int i = 0; i < liczbaKostek; i++) {
            int wynikRzutu = random.nextInt(6) + 1;  // Rzut kostką (1-6)
            System.out.println("Kostka " + (i + 1) + ": " + wynikRzutu);

            // Zliczanie wyników
            licznik.put(wynikRzutu, licznik.getOrDefault(wynikRzutu, 0) + 1);
        }

        // Obliczanie sumy wyników powtórzeń
        int sumaPowtorzen = 0;
        for (Map.Entry<Integer, Integer> entry : licznik.entrySet()) {
            int liczba = entry.getKey();
            int liczbaPowtorzen = entry.getValue();

            if (liczbaPowtorzen > 1) {
                sumaPowtorzen += liczba * liczbaPowtorzen;  // Dodajemy do sumy tylko liczby, które występują więcej niż raz
            }
        }

        System.out.println("Suma wyników powtórzeń: " + sumaPowtorzen);
    }
}
