package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        String carNames = scanner.nextLine();
        return List.of(carNames.split(DELIMITER));
    }

    public int readTryCount() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }
}
