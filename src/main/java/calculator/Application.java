package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runCalculator(askInput());
    }

    public static int runCalculator(String input) {
        if (isNotValidateInput(input)) {
            return 0;
        }

        return sumAndDivideInput(input);
    }

    private static boolean isNotValidateInput(String input) {
        if (isNullInput(input) || isEmptyInput(input) || isBlankInput(input)) {
            return true;
        }
        return false;
    }

    private static boolean isBlankInput(String input) {
        return input.isBlank();
    }

    private static boolean isEmptyInput(String input) {
        return input.isEmpty();
    }

    private static boolean isNullInput(String input) {
        return input == null;
    }

    private static String askInput () {
        return scanner.nextLine();
    }

    private static int sumAndDivideInput(String input) {

        return makeSumOfNumbers(divideInput(input));
    }

    private static int makeSumOfNumbers(List<String> numbers) {
        int sumOfNumbers = 0;
        for (String number : numbers) {
            sumOfNumbers += Integer.parseInt(number);
        }
        return sumOfNumbers;
    }

    private static List<String> divideInput(String input) {
        return Arrays.asList(input.split(",|:"));
    }
}
