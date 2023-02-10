package view;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분).";
    private static final String REQUEST_MOVE_COUNT = "시도할 회수는 몇회인가요?";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String requestCarName() {
        System.out.println(REQUEST_CAR_NAME);
        return scanner.nextLine().replace(" ", "");
    }

    public String requestMoveCount() {
        System.out.println(REQUEST_MOVE_COUNT);
        return scanner.nextLine();
    }

}
