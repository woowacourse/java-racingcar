package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        Validator.validateAll(value);
        //String value = scanner.nextLine().replaceAll(" ", "");
      //  Calculator calculator = new Calculator(array);
      //  System.out.println(calculator.calculate()); //sout
    }
}
