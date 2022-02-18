package racingcar.views;

import racingcar.utils.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_REPEATS = "시도할 회수는 몇회인가요?";
    private final static String CAR_NAME_DISTRIBUTOR = ",";

    final static InputValidation inputValidation = new InputValidation();
    final static Scanner scanner = new Scanner(System.in);

    public static List<String> inputValidNames() {
        final String names = inputNames();
        return Arrays.stream(names.split(CAR_NAME_DISTRIBUTOR))
                .collect(Collectors.toList());
    }

    private static String inputNames() {
        try {
            System.out.println(INPUT_CAR_NAME);
            final String names = scanner.next();
            inputValidation.validateName(names);
            return names;
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage() + System.lineSeparator());
            return inputNames();
        }
    }

    public static int inputRepeats() {
        try {
            System.out.println(INPUT_REPEATS);
            final String repeats = scanner.next();
            final int repeatsNumber = inputValidation.checkIntegerRepeats(repeats);
            inputValidation.checkNegativeRepeats(repeatsNumber);
            return repeatsNumber;
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage() + System.lineSeparator());
            return inputRepeats();
        }
    }
}
