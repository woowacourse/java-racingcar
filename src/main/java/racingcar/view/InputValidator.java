package racingcar.view;

public class InputValidator {
    public static void checkCarNamesInput(String carNamesLine) {
        if (carNamesLine.equals("")) {
            throw new RuntimeException("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
        }
    }

    public static void checkTrialCount(String line) throws RuntimeException {
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
