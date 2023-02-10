package view;

import error.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String NUMERIC_FORMAT = "^[0-9]*$";
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> readCarNames() {
        printMessage(Message.ASK_CAR_NAMES);
        List<String> input = Arrays.stream(readLine().split(DELIMITER))
                .collect(Collectors.toList());
        validateNames(input);

        return input;
    }

    public static int readCount() {
        printMessage(Message.ASK_TRY_COUNT);
        String input = readLine();
        validateCount(input);

        return Integer.parseInt(input);
    }

    private static void validateNames(List<String> input) {
        if (input.size() != input.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAMES.getValue());
        }
    }

    private static void validateCount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMERIC.getValue());
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches(NUMERIC_FORMAT);
    }

    private static String readLine() {
        return sc.nextLine();
    }

    private static void printMessage(Message message) {
        System.out.println(message.value);
    }

    private enum Message {
        ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
        ASK_TRY_COUNT("시도할 횟수는 몇회인가요?");

        private final String value;

        Message(String value) {
            this.value = value;
        }
    }

}
