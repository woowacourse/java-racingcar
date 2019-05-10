package racingcar.view;

import racingcar.constant.MessageConstants;

import java.util.*;
import java.util.regex.Pattern;

public class InputView {
    private final int MINIMUM_PLAYER = 1;
    private final int NAME_LENGTH = 5;
    private final Scanner SCANNER = new Scanner(System.in);
    private final String PATTERN = "^[0-9]$";

    public String[] inputName() {
        System.out.println(MessageConstants.INPUT_CARNAME);

        String carNames = SCANNER.nextLine().trim();
        String[] carName = carNames.split(",");

        if (checkCarNameValidate(carNames)) {
            return inputName();
        }

        return carName;
    }

    private boolean checkCarNameValidate(String carNames) {
        String[] carName = carNames.split(",");

        if (overLengthName(carName)) return true;
        if (hasBlank(carNames)) return true;
        if (hasNotAnotherPlayer(carName)) return true;
        if (overLapName(carName)) return true;

        return hasMiddleBlank(carName);
    }

    public int inputNumber() {
        System.out.println(MessageConstants.INPUT_ROUND);
        String inputNumber = SCANNER.nextLine();

        if (checkNumberValidate(inputNumber)) {
            return inputNumber();
        }

        return Integer.parseInt(inputNumber);
    }

    private boolean checkNumberValidate(String inputNumber) {
        if (hasBlank(inputNumber)) return true;
        if (hasCharacter(inputNumber)) return true;

        return hasNegativeNumber(inputNumber);
    }

    private boolean hasBlank(String carNames) {
        if (carNames.isEmpty()) {
            System.err.println(MessageConstants.ERROR_EMPTY);
            return true;
        }
        return false;
    }

    private boolean overLengthName(String[] carName) {
        if (Arrays.stream(carName).anyMatch(name -> name.length() >= NAME_LENGTH)) {
            System.err.println(MessageConstants.ERROR_OVERLENGTH);
            return true;
        }

        return false;
    }

    private boolean hasNotAnotherPlayer(String[] carName) {
        if (carName.length == MINIMUM_PLAYER) {
            System.err.println(MessageConstants.ERROR_PLAYER_NUMBER);
            return true;
        }
        return false;
    }

    private boolean overLapName(String[] carName) {
        Set<String> compareName = new HashSet<>(Arrays.asList(carName));

        if (carName.length != compareName.size()) {
            System.err.println(MessageConstants.ERROR_DUPLICATE_NAME);
            return true;
        }
        return false;
    }

    private boolean hasMiddleBlank(String[] carNames) {
        long emptyNameCount = Arrays.stream(carNames)
                .map(c -> c.replace(" ", ""))
                .filter(String::isEmpty).count();

        if (emptyNameCount > 0) {
            System.err.println(MessageConstants.ERROR_CONTAIN_EMPTY);
            return true;
        }

        return false;
    }


    private boolean hasNegativeNumber(String inputNumber) {
        if (Integer.parseInt(inputNumber) <= 0) {
            System.err.println(MessageConstants.ERROR_MINUS_NUMBER);
            return true;
        }

        return false;
    }

    private boolean hasCharacter(String inputNumber) {
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
