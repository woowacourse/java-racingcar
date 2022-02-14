package racingcar.ui;

import java.util.Scanner;

public class RacingCarInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_INPUT_MESSAGE
        = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_INPUT_MESSAGE
        = "시도할 회수는 몇회인가요?";

    public static String userCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }


    public static String userRoundInput() {
        System.out.println(ROUND_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
