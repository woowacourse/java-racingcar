package racingcar.ui;

import java.util.List;
import java.util.Scanner;
import racingcar.util.TextSplit;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final int MINIMUM_TRY_COUNT = 1;
    private static final String DELIMITER = ",";


    public static List<String> carNames() {
        try {
            String input = input();

            if (!input.contains(DELIMITER)) {
                throw new IllegalArgumentException("[ERROR] 구분자(" + DELIMITER + ")가 필요해요.");
            }

            return TextSplit.split(input, DELIMITER);
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());

            return carNames();
        }
    }

    public static int tryCount() {
        try {
            return inputTryCount();
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());

            return tryCount();
        }
    }

    private static int inputTryCount() throws IllegalArgumentException {
        int tryCount;

        try {
            tryCount = Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능해요");
        }
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 " + MINIMUM_TRY_COUNT + "미만일 수 없어요.");
        }

        return tryCount;
    }

    private static String input() {
        return scanner.nextLine();
    }
}
