package racingCar.view;

import java.util.Scanner;

public class Input {
    private static final String REQUEST_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(REQUEST_NAMES_MESSAGE);
        return scanner.next();
    }

    public static String inputCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(REQUEST_COUNT_MESSAGE);
        return scanner.next();
    }
}
