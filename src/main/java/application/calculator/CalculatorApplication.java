package application.calculator;

public class CalculatorApplication {
    public static void runCalculator() {
        Calculate calculate = new Calculate();
        try {
            String userInput = UserInputScanner.inputStringEquation();
            int result = Calculate.calculation(calculate.makeNumbersList(userInput));
            System.out.println(userInput + " => " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            runCalculator();
        }
    }

    public static void main(String[] args) {
        runCalculator();
    }
}
