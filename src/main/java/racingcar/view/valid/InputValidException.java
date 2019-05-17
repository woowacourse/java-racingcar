package racingcar.view.valid;

import racingcar.constant.MessageConstants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidException {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_PLAYER = 1;
    private static final Pattern pattern = Pattern.compile("^[0-9]$");

    public static boolean hasBlank(String[] inputName) {
        if (inputName.length == MINIMUM_PLAYER && inputName[0].trim().equals("")) {
            System.err.println(MessageConstants.ERROR_EMPTY);
            return true;
        }
        return false;
    }

    public static boolean overLengthName(String[] inputName) {
        if (Arrays.stream(inputName).anyMatch(name -> name.length() >= MAX_NAME_LENGTH)) {
            System.err.println(MessageConstants.ERROR_OVERLENGTH);
            return true;
        }

        return false;
    }

    public static boolean hasNotAnotherPlayer(String[] inputName) {
        if (inputName.length == MINIMUM_PLAYER) {
            System.err.println(MessageConstants.ERROR_PLAYER_NUMBER);
            return true;
        }
        return false;
    }

    public static boolean overLapName(String[] inputName) {
        Set<String> compareName = new HashSet<>(Arrays.asList(inputName));

        if (inputName.length != compareName.size()) {
            System.err.println(MessageConstants.ERROR_DUPLICATE_NAME);
            return true;
        }
        return false;
    }

    public static boolean hasMiddleBlank(String[] inputName) {
        long emptyNameCount = Arrays.stream(inputName).map(c -> c.replace(" ", "")).filter(String::isEmpty).count();

        if (emptyNameCount > 0) {

            System.err.println(MessageConstants.ERROR_CONTAIN_EMPTY);
            return true;
        }

        return false;
    }

    public static boolean hasBlankNumber(String inputNumber) {
        if (inputNumber.trim().equals("")) {
            System.err.println(MessageConstants.ERROR_EMPTY);
            return true;
        }

        return false;
    }

    public static boolean hasNegativeNumber(String inputNumber) {
        if (Integer.parseInt(inputNumber) <= 0) {
            System.err.println(MessageConstants.ERROR_MINUS_NUMBER);
            return true;
        }

        return false;
    }

    public static boolean hasCharacter(String inputNumber) {
        Matcher matcher = pattern.matcher(inputNumber);

        if (inputNumber.charAt(0) == '-') {
            return false;
        }
        if (!matcher.find()) {
            System.err.println(MessageConstants.ERROR_INPUT_CHAR);
            return true;
        }
        return false;
    }
}
