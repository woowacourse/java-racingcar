package view.input;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final InputValidator inputValidator = new InputValidator();

    private final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readCarName() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);

        final String delimiter = ",";
        String carNames = scanner.nextLine();

        return List.of(carNames.split(delimiter));
    }

    public int readGameTry() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);

        String gameTry = scanner.nextLine();

        inputValidator.validateGameTry(gameTry);
        return Integer.parseInt(gameTry);
    }
}
