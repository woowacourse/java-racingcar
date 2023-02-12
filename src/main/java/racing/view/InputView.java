package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String INPUT_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println(INPUT_NAMES);
        String input = SCANNER.next();
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        return inputNumber();
    }

    private static int inputNumber() {
        try {
            String input = SCANNER.next();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
