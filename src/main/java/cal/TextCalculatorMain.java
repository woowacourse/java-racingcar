package cal;

import java.util.Scanner;

public class TextCalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextCalculator textCalculator = new TextCalculator(scanner.nextLine());
        System.out.println(textCalculator.calculate());
    }
}
