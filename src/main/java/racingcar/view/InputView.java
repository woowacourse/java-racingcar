package racingcar.view;

import racingcar.utils.SplitUtil;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String EMPTY_STRING_ERROR_MESSAGE = "잘못된 입력입니다.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> getCarNamesInput() {
        OutputView.showCarNameGuideMessage();
        return validateCarNamesInput(scanner.nextLine());
    }

    public static String getLapInput() {
        OutputView.showLapGuideMessage();
        return scanner.nextLine();
    }

    private static List<String> validateCarNamesInput(String carNamesInput) {
        if (carNamesInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_STRING_ERROR_MESSAGE);
        }
        return SplitUtil.splitCarNames(carNamesInput);
    }
}
