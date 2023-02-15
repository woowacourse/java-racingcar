package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

            return inputCarNamesScanner();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return inputCarNames();
        }
    }

    private static String inputCarNamesScanner() {
        String carNames = input();

        if (carNames.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 한 글자 이상 입력해주세요.");
        }

        return carNames;
    }

    public static int inputTryCount() {
        try {
            System.out.println("시도할 횟수는 몇회인가요?");

            return inputTryCountScanner();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());

            return inputTryCount();
        }
    }

    private static int inputTryCountScanner() throws IllegalArgumentException {
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
