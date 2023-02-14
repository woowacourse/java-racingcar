package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final int CAR_NAMES_UPPER_BOUND_INCLUSIVE = 10_000_000;
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String INVALID_INPUT_LENGTH_MESSAGE = "입력값은 최대 1000만 글자여야 합니다";
    private static final String TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String rawCarNames = scanner.nextLine();
        validateRawCarNames(rawCarNames);
        return toList(rawCarNames.split(CAR_NAMES_DELIMITER));
    }

    private void validateRawCarNames(String rawCarNames) {
        if (rawCarNames.length() > CAR_NAMES_UPPER_BOUND_INCLUSIVE ||
                rawCarNames.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH_MESSAGE);
        }
    }

    private List<String> toList(String[] names) {
        return new ArrayList<>(List.of(names));
    }

    public int readTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String tryCount = scanner.nextLine();
        return validateTryCount(tryCount);
    }

    private int validateTryCount(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }
}
