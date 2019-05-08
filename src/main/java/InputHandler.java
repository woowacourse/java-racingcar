import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    static final String[] operators = {"+", "-", "*", "/"};
    static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        String input = scanner.nextLine();
        return input;
    }

    public static String[] splitStringToArray(String input) {
        return input.split(" ");
    }

    public static boolean canCalculate(String[] inputs) {
        boolean isOperator = false;
        boolean result = true;

        for (int i = 0; i < inputs.length && result; i++, isOperator = !isOperator) {
            result = checkString(isOperator, inputs[i]);
        }

        return result && (inputs.length > 0) && isOperator;
    }

    public static boolean checkString(boolean isOperator, String input) {
        if (isOperator) {
            return Arrays.asList(operators).contains(input);
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }


}
