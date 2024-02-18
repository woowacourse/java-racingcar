package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAMES_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carNames = scanner.nextLine();
        validateStartsOrEndsWithDelimiter(carNames);

        return Arrays.stream(carNames.split(CAR_NAMES_DELIMITER)).toList();
    }

    private void validateStartsOrEndsWithDelimiter(String input) {
        if (input.startsWith(CAR_NAMES_DELIMITER) || input.endsWith(CAR_NAMES_DELIMITER)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 시작하거나 끝날 수 없습니다.");
        }
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
