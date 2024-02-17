package racingcar.view;

import java.util.List;
import java.util.Arrays;
import java.util.function.Supplier;

public class InputView {
    private static final int MIN_TRY_COUNT = 0;
    private static final int MAX_TRY_COUNT = 1_000;
    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    private InputView() {
        // 인스턴스 생성 방지용
    }

    public static List<String> readCarNames(Supplier<String> reader) {
        System.out.println(ASK_CAR_NAMES);
        String input = reader.get();
        validateNotEmpty(input);
        validateEndsWithComma(input);
        return splitByComma(input);
    }

    public static int readTryCount(Supplier<String> reader) {
        System.out.println(ASK_TRY_COUNT);
        String input = reader.get();
        validateNotEmpty(input);
        return parseTryCount(input);
    }

    private static void validateNotEmpty(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private static void validateEndsWithComma(String input) throws IllegalArgumentException {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다.");
        }
    }

    private static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }

    private static int parseTryCount(final String input) {
        int tryCount;
        try {
            tryCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수를 입력해야 합니다.");
        }
        validateTryCountRange(tryCount);
        return tryCount;
    }

    private static void validateTryCountRange(final int tryCount) {
        if (tryCount <= MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수를 입력해야 합니다.");
        }
        if (tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(
                    String.format("시도 횟수는 %,d 이하여야 합니다.", MAX_TRY_COUNT)
            );
        }
    }
}
