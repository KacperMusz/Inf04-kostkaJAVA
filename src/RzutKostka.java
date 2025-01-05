import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RzutKostka {
    public void funckja1() {
        UserInput();
    }
    private void UserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
        int wybor = scanner.nextInt();
        if (wybor >= 3 && wybor <=10){
            WynikLosowania(wybor);
        }else {
            System.out.println("Podana zle ilosc rzutów kostka");
        }
    }
    private void WynikLosowania(int x){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> powtarzajaceSie = new ArrayList<>();
        int wynik = 0;

        for (int i = 0; i < x; i++){
            int number = random.nextInt(6) + 1;
            System.out.println("Kostka " + (i+1) + ": " + number);
            list.add(number);
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int num: list){
                if (num == i){
                    count ++;
                }
            }
            if (count >= 2){
                for (int j = 0; j < count; j++) {
                    wynik += i;
                }
            }
        }
        System.out.println(wynik);
    }


}
