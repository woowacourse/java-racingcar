package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String carNames() {
        return input();
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
        if (tryCount < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1미만일 수 없어요.");
        }

        return tryCount;
    }

    private static String input() {
        return scanner.nextLine();
    }
}
