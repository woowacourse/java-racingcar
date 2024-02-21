package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름을 쉼표(,)를 기준으로 구분).";
    private static final String ENTER_TRY_COUNT = "시도할 횟수는 몇회인가요?";
    private static final String NULL_OR_EMPTY_INPUT = "입력이 null이거나 비어 있습니다.";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println(ENTER_CAR_NAMES);
        return parseNames(readLine());
    }

    private List<String> parseNames(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }

    private String readLine() {
        String input = scanner.nextLine();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT);
        }
        return input;
    }

    public int readTryCount() {
        System.out.println(ENTER_TRY_COUNT);
        return readInt();
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }
}
