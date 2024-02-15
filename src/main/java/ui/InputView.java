package ui;

import static enums.Delimiter.COMMA;

import java.util.Scanner;
import util.InputValidator;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator carNamesValidator;
    private final InputValidator tryCountValidator;

    public InputView(InputValidator carNamesValidator, InputValidator tryCountValidator) {
        this.carNamesValidator = carNamesValidator;
        this.tryCountValidator = tryCountValidator;
    }

    public String[] inputCarNames() {
        System.out.printf("경주할 자동차 이름을 입력하세요(이름은 %s(%s) 기준으로 구분).%n", COMMA.getKorName(), COMMA.getValue());
        String carNames = scanner.nextLine();
        carNamesValidator.validate(carNames);
        return carNames.split(COMMA.getValue());
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String tryCount = scanner.nextLine();
        tryCountValidator.validate(tryCount);
        return Integer.parseInt(tryCount);
    }
}
