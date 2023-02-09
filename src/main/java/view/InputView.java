package view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE =
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_MESSAGE =
            "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCarsName() {
        print(INPUT_CAR_NAMES_MESSAGE);
        return input();
    }

    public String inputRound() {
        print(INPUT_ROUND_MESSAGE);
        return input();
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String input() {
        return scanner.nextLine();
    }
}
