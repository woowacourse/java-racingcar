package cal;

import java.util.Scanner;

public class TextCalculatorMain {
    public static void main(String[] args) {
        TextCalculator textCalculator = new TextCalculator();
        Scanner scanner = new Scanner(System.in);
        textCalculator.calculate(scanner.nextLine());
    }
}
