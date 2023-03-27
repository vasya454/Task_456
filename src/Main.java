import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("INPUT.txt"));
            int last_year = scanner.nextInt();
            int count_of_coins = scanner.nextInt();
            scanner.close();
            int a = 1, b = 1, next_Fib;
            for (int i = 0; i < last_year - 3; i++) {
                next_Fib = a + b;
                a = b;
                b = next_Fib;
            }
           int first = 0, second = 0;
            for (int i = 0; i < count_of_coins; i++) {
                if ((count_of_coins-b*i)%a == 0) { // a*x+b*y=c, y = (c-a*x)/b, x = (c-b*y)/a
                    second = i;
                    first = (count_of_coins-b*i)/a;
                    break;
                }
            }
            FileWriter fileWriter = new FileWriter("OUTPUT.txt");
            fileWriter.write((first + " " + second));
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }
}