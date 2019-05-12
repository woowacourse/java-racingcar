package cal;

import java.util.Scanner;

public class TextCalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextCalculator.calculate(scanner.nextLine());
    }
}
