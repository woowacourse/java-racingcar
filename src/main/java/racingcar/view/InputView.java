package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    static Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        String carNames = scanner.nextLine();
        return List.of(carNames.split(DELIMITER));
    }

    public static int readTryCount() {
        try {
            int tryCount = Integer.parseInt(scanner.nextLine());
            return tryCount;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }
}
