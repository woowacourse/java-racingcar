package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_MOVE_COUNT = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String askCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
        String inputNames = scanner.nextLine();
        return inputNames;
    }

    public String askMoveCount() {
        System.out.println(REQUEST_MOVE_COUNT);
        String inputMoveCount = scanner.nextLine();
        return inputMoveCount;
    }
}
