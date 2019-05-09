package stringcalculator;

public class Calculator {

    public int plus(int result, int target) {
        return result + target;
    }

    public int minus(int result, int target) {
        return result - target;
    }

    public int multiply(int result, int target) {
        return result * target;
    }

    public int divide(int result, int target) {
        return result / target;
    }

    public String[] splitByBlank(String inputText) {
        return inputText.split(" ");
    }
}
