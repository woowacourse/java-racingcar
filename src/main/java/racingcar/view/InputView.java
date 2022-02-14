package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public int inputTryCount() {
        try {
            System.out.println(INPUT_TRY_COUNT_MESSAGE);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("시도횟수는 숫자이어야 합니다.");
        }
    }
}
