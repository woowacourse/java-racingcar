package racingcar.view;

import racingcar.util.Parser;
import racingcar.util.Validator;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static final String CAR_NAMES_INPUT_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MSG = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MSG);

        String carNames = scanner.nextLine();
        Validator.validateNullName(carNames);
        return Parser.parseCarNames(carNames);
    }

    public int readTryCount() {
        System.out.println(TRY_COUNT_INPUT_MSG);

        String tryCount = scanner.nextLine();
        int parsedTryCount = Validator.validateInteger(tryCount);
        Validator.validateTryCount(parsedTryCount);

        return parsedTryCount;
    }

    public void closeResource() {
        scanner.close();
    }
}
