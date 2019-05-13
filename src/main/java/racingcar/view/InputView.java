package racingcar.view;

import racingcar.constant.MessageConstants;

import java.util.*;
import java.util.regex.Pattern;

public class InputView {
    private static final int MINIMUM_PLAYER = 1;
    private static final int NAME_LENGTH = 5;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATTERN = "^[0-9]$";

    public static String[] inputName() {
        System.out.println(MessageConstants.INPUT_CARNAME);

        String carNames = SCANNER.nextLine().trim();
        String[] carName = carNames.split(",");

        if (checkCarNameValidate(carNames)) {
            return inputName();
        }

        return carName;
    }

    public static int inputNumber() {
        System.out.println(MessageConstants.INPUT_ROUND);
        String inputNumber = SCANNER.nextLine();

        if (checkNumberValidate(inputNumber)) {
            return inputNumber();
        }

        return Integer.parseInt(inputNumber);
    }

    private static boolean checkCarNameValidate(String carNames) {
        String[] carName = carNames.split(",");

        if (overLengthName(carName)) return true;
        if (hasBlank(carNames)) return true;
        if (hasNotAnotherPlayer(carName)) return true;
        if (overLapName(carName)) return true;

        return hasMiddleBlank(carName);
    }

    private static boolean checkNumberValidate(String inputNumber) {
        if (hasBlank(inputNumber)) return true;
        if (hasCharacter(inputNumber)) return true;

        return hasNegativeNumber(inputNumber);
    }

    private static boolean hasBlank(String carNames) {
        if (carNames.isEmpty()) {
            System.err.println(MessageConstants.ERROR_EMPTY);
            return true;
        }
        return false;
    }

    private static boolean overLengthName(String[] carName) {
        if (Arrays.stream(carName).anyMatch(name -> name.length() >= NAME_LENGTH)) {
            System.err.println(MessageConstants.ERROR_OVERLENGTH);
            return true;
        }

        return false;
    }

    private static boolean hasNotAnotherPlayer(String[] carName) {
        if (carName.length == MINIMUM_PLAYER) {
            System.err.println(MessageConstants.ERROR_PLAYER_NUMBER);
            return true;
        }
        return false;
    }

    private static boolean overLapName(String[] carName) {
        Set<String> compareName = new HashSet<>(Arrays.asList(carName));

        if (carName.length != compareName.size()) {
            System.err.println(MessageConstants.ERROR_DUPLICATE_NAME);
            return true;
        }
        return false;
    }

    private static boolean hasMiddleBlank(String[] carNames) {
        long emptyNameCount = Arrays.stream(carNames)
                .map(c -> c.replace(" ", ""))
                .filter(String::isEmpty).count();

        if (emptyNameCount > 0) {
            System.err.println(MessageConstants.ERROR_CONTAIN_EMPTY);
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
        if (!Pattern.matches(PATTERN, inputNumber)) {
            System.err.println(MessageConstants.ERROR_INPUT_CHAR);
            return true;
        }

        return false;
    }
}
