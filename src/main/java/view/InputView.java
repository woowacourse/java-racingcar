package view;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    public static final String NON_NUMBER_ERROR = "숫자만 입력 가능합니다.";
    public static final String EXCEEDED_CAR_NAME_LENGTH_ERROR = "자동차명은 1 ~ 5 글자로 입력해야합니다.";
    public static final String NUMBER_OF_TIME_ERROR = "1 이상만 가능합니다.";
    public static final String EXISTS_DUPLICATE_CAR_NAME_ERROR = "자동차명은 중복되어선 안됩니다.";
    private static final String DELIMITER = ",";
    private static final String NUMBER_OF_TIME_HEADER = "시도할 횟수는 몇회인가요?";
    public static final String CAR_NAMES_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static final int LENGTH_LOWER_BOUND = 1;
    public static final int LENGTH_UPPER_BOUND = 5;
    public static final int NUMBER_OF_TIME_LOWER_BOUND = 0;
    public static final int NUMBER_OF_TIME_UPPER_BOUND = 101;


    private Scanner console;

    public InputView(InputStream consoleConnector) {
        console = new Scanner(consoleConnector);
    }

    public List<String> carNames() {
        System.out.println(CAR_NAMES_HEADER);
        List<String> carNames = Arrays.asList(console.nextLine().split(DELIMITER));
        carNames = trimCarNames(carNames);
        carNames(carNames);

        return carNames;
    }

    private List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int numberOfTimes() {
        System.out.println(NUMBER_OF_TIME_HEADER);
        String number = console.nextLine();
        numberOfTimes(number);

        return Integer.parseInt(number);
    }

    private static boolean isCorrectLength(List<String> carNames) {
        return carNames.stream()
                .allMatch(carName -> LENGTH_LOWER_BOUND <= carName.length() && carName.length() <= LENGTH_UPPER_BOUND);
    }
    public static void carNames(List<String> carNames) {
        exceededCarNameLength(carNames);
        existDuplicateCarName(carNames);
    }

    private static void exceededCarNameLength(List<String> carNames) {
        if (!isCorrectLength(carNames)) {
            throw new IllegalArgumentException(EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void existDuplicateCarName(List<String> carName) {
        Set<String> duplicateChecker = new HashSet<>(carName);

        if (duplicateChecker.size() != carName.size()) {
            throw new IllegalArgumentException(EXISTS_DUPLICATE_CAR_NAME_ERROR);
        }
    }

    public static void numberOfTimes(String input) {
        nonNumber(input);
        int number = Integer.parseInt(input);

        if (number <= NUMBER_OF_TIME_LOWER_BOUND || NUMBER_OF_TIME_UPPER_BOUND <= number) {
            throw new IllegalArgumentException(NUMBER_OF_TIME_ERROR);
        }
    }

    private static void nonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_NUMBER_ERROR);
        }
    }
}
