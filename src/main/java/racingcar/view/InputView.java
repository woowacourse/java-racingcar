package racingcar.view;

import racingcar.constant.MessageConstants;

import java.util.*;
import java.util.regex.Pattern;

public class InputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_PLAYER = 1;
    private static final String pattern = "^[0-9]$";
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputName() {
        System.out.println(MessageConstants.INPUT_CARNAME);
        String[] inputName = scanner.nextLine().trim().split(",");

        if (overLengthName(inputName) || hasBlank(inputName) || hasNotAnotherPlayer(inputName)
                || overLapName(inputName) || hasMiddleBlank(inputName)) {
            return inputName();
        }

        return inputName;
    }

    public static int inputNumber() {
        System.out.println(MessageConstants.INPUT_ROUND);
        String inputNumber = scanner.nextLine();

        if (hasBlankNumber(inputNumber) || hasCharacter(inputNumber) || hasNegativeNumber(inputNumber)) {
            return inputNumber();
        }

        return Integer.parseInt(inputNumber);
    }

    private static boolean hasBlank(String[] inputName) {
        if (inputName.length == MINIMUM_PLAYER && inputName[0].trim().equals("")) {
            System.err.println(MessageConstants.ERROR_EMPTY);
            return true;
        }
        return false;
    }

    private static boolean overLengthName(String[] inputName) {
        if (Arrays.stream(inputName).anyMatch(name -> name.length() >= MAX_NAME_LENGTH)) {
            System.err.println(MessageConstants.ERROR_OVERLENGTH);
            return true;
        }

        return false;
    }

    private static boolean hasNotAnotherPlayer(String[] inputName) {
        if (inputName.length == MINIMUM_PLAYER) {
            System.err.println(MessageConstants.ERROR_PLAYER_NUMBER);
            return true;
        }
        return false;
    }

    private static boolean overLapName(String[] inputName) {
        Set<String> compareName = new HashSet<>(Arrays.asList(inputName));

        if (inputName.length != compareName.size()) {
            System.err.println(MessageConstants.ERROR_DUPLICATE_NAME);
            return true;
        }
        return false;
    }

    private static boolean hasMiddleBlank(String[] inputName) {
        long emptyNameCount = Arrays.stream(inputName).map(c -> c.replace(" ", "")).filter(String::isEmpty).count();

        if (emptyNameCount > 0) {
            System.err.println(MessageConstants.ERROR_CONTAIN_EMPTY);
            return true;
        }

        return false;
    }

    private static boolean hasBlankNumber(String inputNumber) {
        if (inputNumber.trim().equals("")) {
            System.err.println(MessageConstants.ERROR_EMPTY);
            return true;
        }

        return false;
    }

    private static boolean hasNegativeNumber(String inputNumber) {
        if (Integer.parseInt(inputNumber) <= 0) {
            System.err.println(MessageConstants.ERROR_MINUS_NUMBER);
            return true;
        }

        return false;
    }

    private static boolean hasCharacter(String inputNumber) {
        char[] inputChar = inputNumber.toCharArray();

        if (inputChar[0] == '-') {
            return false;
        }
        if (!Pattern.matches(pattern, inputNumber)) {
            System.err.println(MessageConstants.ERROR_INPUT_CHAR);
            return true;
        }

        return false;
    }

}
