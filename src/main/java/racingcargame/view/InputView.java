package racingcargame.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_CAR_NAME_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_NUMBER_HEADER = "시도할 회수는 몇회인가요?";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력해 주세요.";

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAME_HEADER);
        return SCANNER.nextLine();
    }

    public static int inputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER_HEADER);
        int input;
        try {
            input = SCANNER.nextInt();
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
            input = SCANNER.nextInt();
        }
        return input;
    }
}
