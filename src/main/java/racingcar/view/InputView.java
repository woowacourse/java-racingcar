package racingcar.view;

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

    private static void validateNotEmpty(String input) throws IllegalArgumentException{
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private static void validateEndsWithComma(String input) throws IllegalArgumentException {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다.");
        }
    }

    private static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
