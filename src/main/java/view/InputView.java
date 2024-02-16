package view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_PROMPT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarName() {
        System.out.println(MESSAGE_PROMPT_CAR_NAMES);

        return scanner.nextLine();
    }

    public static String inputTryCount() {
        System.out.println(MESSAGE_PROMPT_TRY_COUNT);

        return scanner.nextLine();
    }
}
