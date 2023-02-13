package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String carNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            return inputCarNames();
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return carNames();
        }
    }

    private static String inputCarNames() {
        String carNames = input();
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 한 글자 이상 입력해주세요.");
        }

        return carNames;
    }

    public static int tryCount() {
        try {
            System.out.println("시도할 횟수는 몇회인가요?");
            return inputTryCount();
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());

            return tryCount();
        }
    }

    private static int inputTryCount() throws IllegalArgumentException {
        String inputTryCount = input();
        int tryCount;

        try {
            tryCount = Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능해요.");
        }

        return tryCount;
    }

    private static String input() {
        return scanner.nextLine();
    }
}
