package racingcar;

import java.util.Scanner;

class Input {
    private static Scanner SCANNER = new Scanner(System.in);

    private static String INPUT_CAR_NAMES;
    private static String INPUT_TOTAL_ROUND;
    private static String INVALID_NUMBER_INPUT;

    static {
        INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요. [이름은 쉼표(,)를 기준으로 구분]";
        INPUT_TOTAL_ROUND = "시도할 횟수는 몇 회인가요?";
        INVALID_NUMBER_INPUT = "올바른 숫자가 입력되지 않았습니다. 다시 입력해 주세요.";
    }

    private static String inputStringWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

    static String[] carNames() {
        String[] carNames = inputStringWithMessage(INPUT_CAR_NAMES)
                .strip()
                .split(",\\s*");

        for (String carName : carNames) {
            try {
                new Car(carName);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                return carNames(); // 재귀
            }
        }

        return carNames;
    }

    static int totalRound() {
        int result;

        try {
            result = Integer.parseInt(inputStringWithMessage(INPUT_TOTAL_ROUND));
        } catch (NumberFormatException error) {
            result = inputTotalRoundRetry();
        }

        if (result < 1) {
            result = inputTotalRoundRetry();
        }

        return result;
    }

    private static int inputTotalRoundRetry() { // 재귀용 함수
        System.out.println(INVALID_NUMBER_INPUT);
        return totalRound();
    }
}
