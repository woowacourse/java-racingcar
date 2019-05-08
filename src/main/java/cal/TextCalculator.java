package cal;

import java.util.Scanner;

public class TextCalculator {
    private static double result = 0;
    private static TextCalculator textCalculator;
    private static Scanner scanner = new Scanner(System.in);

    public double calculate(String inputText) {
        String tokens[] = inputText.trim().split(" ");

        result = toDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            detectOperator(tokens, i);
        }

        return result;
    }

    private void detectOperator(String[] tokens, int i) {
        switch (tokens[i]) {
            case "+":
                result = Calculator.plus(result, toDouble(tokens[i + 1]));
                break;

            case "-":
                result = Calculator.minus(result, toDouble(tokens[i + 1]));
                break;

            case "*":
                result = Calculator.multiply(result, toDouble(tokens[i + 1]));
                break;

            case "/":
                result = Calculator.divide(result, toDouble(tokens[i + 1]));
                break;
            default:
                throw new IllegalArgumentException("연산자가 잘못되었습니다.");
        }
    }

    private double toDouble(String value){
        try{
            return Double.parseDouble(value);
        }catch (Exception e){
            throw new IllegalArgumentException("적절한 입력이 아닙니다.");
        }
    }

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
            run();
        }
    }

    private static void run(){
        String inputText = scanner.nextLine();
        textCalculator = new TextCalculator();
        textCalculator.calculate(inputText);
    }

}
