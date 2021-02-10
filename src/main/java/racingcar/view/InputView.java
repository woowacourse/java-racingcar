package racingcar.view;

import racingcar.utils.SplitUtil;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int MINIMUM_LAP_COUNT = 1;
    private static final String NUMERIC_REGULAR_EXPRESSION = "\\d+";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "숫자를 입력하세요.";
    private static final String NOT_OVER_ONE_ERROR_MESSAGE = "1 이상의 숫자를 입력하세요.";
    private static final String EMPTY_STRING_ERROR_MESSAGE = "잘못된 입력입니다.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> getCarNamesInput() {
        OutputView.showCarNameGuideMessage();
        return validateCarNamesInput(scanner.nextLine());
    }

    public static int getLapInput() {
        OutputView.showLapGuideMessage();
        return validateLapInput(scanner.nextLine());
    }

    private static List<String> validateCarNamesInput(String carNamesInput) {
        if (carNamesInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_STRING_ERROR_MESSAGE);
        }
        return SplitUtil.splitCarNames(carNamesInput);
    }

    private static int validateLapInput(String lapInput) {
        if (!lapInput.matches(NUMERIC_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }

        int lap = Integer.parseInt(lapInput);

        if (lap < MINIMUM_LAP_COUNT) {
            throw new IllegalArgumentException(NOT_OVER_ONE_ERROR_MESSAGE);
        }
        return lap;
    }
}
