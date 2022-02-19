package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SIGN_OF_CAR_NAME = ",";
    private static final String MUST_BE_INTEGER = "[ERROR] 시도 횟수는 숫자만 허용됩니다.";

    private InputView() {
    }

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine().split(SIGN_OF_CAR_NAME);
    }

    public static int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String num = SCANNER.nextLine();
        return validateIntegerThenParse(num);
    }

    public static int validateIntegerThenParse(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(MUST_BE_INTEGER);
        }
    }
}
