package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] splitedValues = inputExpression();
        Calculator calculator = new Calculator(splitedValues);
        System.out.println(calculator.calculate());
    }

    private static String[] inputExpression() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("계산식을 입력해주세요.");
            String value = scanner.nextLine();
            String[]  splitedValues = value.split(" ");
            try {
                Validator validator = new Validator(value, splitedValues);
                validator.validateAll();
                return splitedValues;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
