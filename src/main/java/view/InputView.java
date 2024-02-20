package view;

import java.util.Scanner;

public class InputView {
    private final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private Scanner scanner = new Scanner(System.in);

    public String inputCarName() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);

        return scanner.nextLine();
    }

    public String inputRound() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);

        return scanner.nextLine();
    }
}
