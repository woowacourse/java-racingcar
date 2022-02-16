package racingcar.validator;

import java.util.List;

public class InputValidator {
    private static int MAX_CAR_NAME_LENGTH = 5;
    private static String EMPTY_STRING = "";

    public static void checkCarNamesLine(String carNamesLine) {
        if (carNamesLine.equals(EMPTY_STRING)) {
            throw new RuntimeException("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
        }
    }

    public static void checkCarNames(List<String> carNames) {
        for (String carName : carNames) {
            carNameLengthException(carName);
            carNameIsEmptyException(carName);
            carNameIsSpaceException(carName);
        }
        carNameDuplicationException(carNames);
    }

    private static void carNameLengthException(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private static void carNameIsEmptyException(String carName) {
        if (carName.equals(EMPTY_STRING)) {
            throw new RuntimeException("모든 자동차 이름은 반드시 존재해야 합니다.");
        }
    }

    private static void carNameIsSpaceException(String carName) {
        if (carName.trim().equals(EMPTY_STRING)) {
            throw new RuntimeException("자동차 이름은 공백으로 설정할 수 없습니다.");
        }
    }

    private static void carNameDuplicationException(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new RuntimeException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void checkTrialCountLine(String line) {
        trialCountNotNumericValueException(line);
        trialCountZeroException(line);
    }

    private static void trialCountNotNumericValueException(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("시도 횟수가 숫자가 아닙니다.");
        }
    }

    private static void trialCountZeroException(String line) {
        if (Integer.parseInt(line) <= 0) {
            throw new RuntimeException("시도 횟수가 음수나 0이 될 수 없습니다.");
        }
    }
}
