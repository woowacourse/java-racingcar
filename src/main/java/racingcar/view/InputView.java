package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해야 합니다";
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return SCANNER.nextLine();
    }

    public static int inputGameCount() {
        System.out.println(GAME_COUNT_INPUT_MESSAGE);
        int count = scanInt();
        validateCount(count);
        return count;
    }

    private static int scanInt() {
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }
}
