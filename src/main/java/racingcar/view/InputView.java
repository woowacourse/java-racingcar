package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAMES_GUIDE_MESSEAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scanCarNames() {
        System.out.println(INPUT_CAR_NAMES_GUIDE_MESSEAGE);
        return scanner.nextLine();
    }
}
