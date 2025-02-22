import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Kosteczka {
    public Kosteczka() {
        userMenu();
    }
    private void userMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;
        while (continueGame){

            System.out.println("Ile kostek chcesz rzucić? (3-10)");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            if (userChoice >= 3 && userChoice <= 10){
                rollDice(userChoice);
            }else {
                System.out.println("podano zła liczbe rzutów kostek");
            }

            System.out.println("jeszcze raz?");
            String s = scanner.nextLine();
            if (s.equals("t")){
                continueGame = true;
            }else if (s.equals("n")){
                continueGame = false;
            }else{
                System.out.println("blad");
            }
        }
        System.out.println("zakonczono grte");
    }

    private void rollDice(int liczbaKostek){
        Map<Integer, Integer> puknty = new HashMap<>();
        //Mapa<K,V> gdzie k to wylosowane oczka a V to ile razy to wypadło
        Random random = new Random();
        for (int i = 0; i < liczbaKostek; i++){
            int wynikRzutu = random.nextInt(1,6);
            System.out.println("Kostka " + (i+1)+": " + wynikRzutu);
            puknty.put(wynikRzutu, puknty.getOrDefault(wynikRzutu, 0) + 1);
        }
        int wynik = 0;
        for (Map.Entry<Integer,Integer> map: puknty.entrySet()){

            int oczka = map.getKey();
            int iloscPowtorzen = map.getValue();

            if (iloscPowtorzen > 1){
                wynik += oczka * iloscPowtorzen;
            }

        }
        System.out.println("twoj wynik to: "+ wynik);
    }



}
