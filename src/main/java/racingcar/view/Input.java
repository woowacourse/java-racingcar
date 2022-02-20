package racingcar.view;

import java.util.Scanner;

public class Input {
    private final static Scanner sc = new Scanner(System.in);
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_MESSAGE);
        String inputName = sc.next();

        return inputName;
    }

    public static String inputTry() {
        System.out.println(INPUT_TRY_MESSAGE);
        String inputTry = sc.next();

        return inputTry;
    }
}
