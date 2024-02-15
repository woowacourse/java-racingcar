package racingcar.view;

import static racingcar.config.RacingCarConfig.MAX_TRY_COUNT;
import static racingcar.config.RacingCarConfig.MIN_TRY_COUNT;
import static racingcar.exception.ExceptionMessage.*;

import java.util.List;
import java.util.Arrays;
import java.util.function.Supplier;

public class InputView {
    private InputView() {}

    public static List<String> readCarNames(Supplier<String> reader) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = reader.get();
        validateNotEmpty(input);
        validateEndsWithComma(input);
        return splitByComma(input);
    }

    public static int readTryCount(Supplier<String> reader) {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = reader.get();
        validateNotEmpty(input);
        return parseTryCount(input);
    }

    private static void validateNotEmpty(String input) throws IllegalArgumentException{
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(NOT_NULL.getMessage());
        }
    }

    private static void validateEndsWithComma(String input) throws IllegalArgumentException {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(NOT_NULL_CAR_NAME.getMessage());
        }
    }

    private static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    private static int parseTryCount(final String input) {
        int tryCount;
        try {
            tryCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_POSITIVE_NUMBER.getMessage());
        }
        validateTryCountRange(tryCount);
        return tryCount;
    }

    private static void validateTryCountRange(final int tryCount) {
        if (tryCount <= MIN_TRY_COUNT.getValue()) {
            throw new IllegalArgumentException(ONLY_POSITIVE_NUMBER.getMessage());
        }
        if (tryCount > MAX_TRY_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT.getMessage());
        }
    }
}
