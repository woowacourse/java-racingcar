package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import racingcar.util.ErrorMessage;
import racingcar.util.IntegerConst;
import racingcar.util.StringConst;

public class InputView {
    private static void isNull(String stringInput) throws IllegalArgumentException {
        if (stringInput == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NULL.getValue());
        }
    }

    private static void isBlank(String stringInput) throws IllegalArgumentException {
        if (stringInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BLANK.getValue());
        }
    }

    private static void isOverSize(String[] splitStringInput) throws IllegalArgumentException {
        int overSizeCount = (int) Arrays.stream(splitStringInput)
            .filter(eachStringInput -> eachStringInput.length() > IntegerConst.SIZE_BOUND.getValue())
            .count();
        if (overSizeCount > IntegerConst.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_SIZE.getValue());
        }
    }

    private static void isZeroCars(String[] splitStringInput) throws IllegalArgumentException {
        if (splitStringInput.length == IntegerConst.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NO_CAR.getValue());
        }
    }

    private static void isSpecialChar(String[] splitStringInput) throws IllegalArgumentException {
        int specialCount = (int)Arrays.stream(splitStringInput)
            .filter(eachStringInput -> !eachStringInput.matches(StringConst.REGEX_PATTERN.getValue()))
            .count();
        if (specialCount > IntegerConst.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_SPECIAL_CHAR.getValue());
        }
    }

    private static void isDuplicate(String[] splitStringInput) throws IllegalArgumentException {
        HashSet<String> nameSet = new HashSet<>(Arrays.asList(splitStringInput));
        if (nameSet.size() != splitStringInput.length) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE.getValue());
        }
    }

    private static void isIntNum(String stringInput) throws IllegalArgumentException {
        if (!stringInput.matches(StringConst.NUMBER_REGEX_PATTERN.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INT_NUM.getValue());
        }
    }

    private static void nullOrBlank(String stringInput) throws IllegalArgumentException {
        isNull(stringInput);
        isBlank(stringInput);
    }

    private static void checkNameError(String nameInput) throws IllegalArgumentException {
        nullOrBlank(nameInput);
        String[] commaSeparateName = nameInput.split(StringConst.DELIMITER.getValue());
        isZeroCars(commaSeparateName);
        isSpecialChar(commaSeparateName);
        isOverSize(commaSeparateName);
        isDuplicate(commaSeparateName);
    }

    private static void checkTurnError(String turnInput) throws IllegalArgumentException {
        nullOrBlank(turnInput);
        isIntNum(turnInput);
    }

	public static String[] getCarNameInput() throws IllegalArgumentException {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		checkNameError(name);
		return name.split(StringConst.DELIMITER.getValue());
	}


	public static int getTurnInput() throws IllegalArgumentException {
		Scanner scanner = new Scanner(System.in);
		String turn = scanner.nextLine();
		checkTurnError(turn);
		return Integer.parseInt(turn);
	}

}
