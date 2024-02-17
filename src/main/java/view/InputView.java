package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.DigitValidator;
import util.SplitValidator;

public class InputView {
    private static final String CAR_NAMES_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carNames = scanner.nextLine();
        SplitValidator.validate(carNames, CAR_NAMES_DELIMITER);

        return Arrays.stream(carNames.split(CAR_NAMES_DELIMITER)).toList();
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        String tryCount = scanner.nextLine();
        DigitValidator.validateIsDigit(tryCount);

        return Integer.parseInt(tryCount);
    }
}
