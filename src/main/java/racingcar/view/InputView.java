package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String EXCEPTION_INPUT_MUST_NUMBER = "[ERROR] 입력은 숫자여야 합니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String askCarName() {
        System.out.println(QUESTION_CAR_NAME);
        return scanner.nextLine();
    }

    public static int askTryCount() {
        System.out.println(QUESTION_TRY_COUNT);
        String userInput = scanner.nextLine();
        checkStringIsNumber(userInput);
        return Integer.parseInt(userInput);
    }

    private static void checkStringIsNumber(String target) {
        for (int i = 0; i < target.length(); ++i) {
            checkCharIsNumber(target.charAt(i));
        }
    }

    private static void checkCharIsNumber(char target) {
        if (target < '0' || target > '9') {
            throw new IllegalArgumentException(EXCEPTION_INPUT_MUST_NUMBER);
        }
    }
}
