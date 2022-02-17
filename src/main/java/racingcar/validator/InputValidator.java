package racingcar.validator;

import java.util.List;
import racingcar.validator.exception.CarNameDuplicationException;
import racingcar.validator.exception.CarNameLengthOverException;
import racingcar.validator.exception.CarNameNotFoundException;
import racingcar.validator.exception.CarNameSpaceException;
import racingcar.validator.exception.EmptyStringException;
import racingcar.validator.exception.TrialCountNotNumericException;
import racingcar.validator.exception.TrialCountNotPositiveException;

public class InputValidator {
    private static int MAX_CAR_NAME_LENGTH = 5;
    private static String EMPTY_STRING = "";

    public static void checkCarNamesLine(String carNamesLine) {
        if (carNamesLine.equals(EMPTY_STRING)) {
            throw new EmptyStringException();
        }
    }

    public static void checkCarNames(List<String> carNames) {
        for (String carName : carNames) {
            checkCarNameLength(carName);
            checkCarNameNotFound(carName);
            checkCarNameIsSpace(carName);
        }
        checkCarNameDuplicated(carNames);
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameLengthOverException(carName.length());
        }
    }

    private static void checkCarNameNotFound(String carName) {
        if (carName.equals(EMPTY_STRING)) {
            throw new CarNameNotFoundException();
        }
    }

    private static void checkCarNameIsSpace(String carName) {
        if (carName.trim().equals(EMPTY_STRING)) {
            throw new CarNameSpaceException();
        }
    }

    private static void checkCarNameDuplicated(List<String> carNames) {
        long count = carNames.stream().distinct().count();
        if (count != carNames.size()) {
            throw new CarNameDuplicationException();
        }
    }

    public static void checkTrialCountLine(String line) {
        checkTrialCountNumeric(line);
        checkTrialCountPositive(line);
    }

    private static void checkTrialCountNumeric(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new TrialCountNotNumericException();
        }
    }

    private static void checkTrialCountPositive(String line) {
        if (Integer.parseInt(line) <= 0) {
            throw new TrialCountNotPositiveException();
        }
    }
}
