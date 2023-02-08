package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = readLine();
        validateCount(input);
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static int readCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = readLine();
        validateCount(input);

        return Integer.parseInt(input);
    }

    private static void validateNames(List<String> input) {
        if (input.size() != input.stream().distinct().count()) {
            throw new IllegalStateException("중복된 이름이 존재합니다.");
        }
    }

    private static void validateCount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalStateException("숫자만 입력해야함");
        }

        if (!isValidRange(Integer.parseInt(input))) {
            throw new IllegalStateException("0이상을 입력해야함");
        }
    }

    private static boolean isNumeric(String input) {
        if (!input.matches("^[0-9]*$")) {
            return false;
        }
        return true;
    }

    private static boolean isValidRange(int input) {
        if (input < 1) {
            return false;
        }
        return true;
    }

    private static String readLine() {
        return sc.nextLine();
    }
}
