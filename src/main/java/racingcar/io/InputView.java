package racingcar.io;

import java.util.List;
import java.util.Scanner;
import racingcar.io.validator.InputValidator;

public class InputView {

    private static final String CAR_NAMES_DELIMITER = ",";
    private final Scanner sc = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String rawCarNames = sc.nextLine();
        return List.of(rawCarNames.split(CAR_NAMES_DELIMITER));
    }

    public int readTryAmount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String text = sc.nextLine();
        InputValidator.validateIntFormat(text);

        return Integer.parseInt(text);
    }
}
