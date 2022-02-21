package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputGameCount() {
        System.out.println(GAME_COUNT_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
