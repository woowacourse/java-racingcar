package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static String MESSAGE_NO_DUPLICATE_CAR_NAMES = "중복된 자동차 이름은 사용할 수 없습니다.";
    private final static String MESSAGE_LENGTH_OF_CAR_NAME = "자동차 이름은 1자 이상 5자 이하여야 합니다.";
    private final static String MESSAGE_NO_SPACE = "입력에 공백을 포함할 수 없습니다.";
    private final static String MESSAGE_ONLY_NUMBER = "시도할 회수는 숫자여야만 가능합니다.";
    private final static String MESSAGE_ONLY_NATURAL_NUMBER = "시도할 회수는 자연수를 입력해 주세요.";
    private final static int MAX_LENGTH_OF_NAME = 5;
    private final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public List<String> getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        List<String> splitCarNames;
        try {
            validateNoSpace(input);
            splitCarNames = getSplitCarNames(input);
            validateLengthOfCarNames(splitCarNames);
            validateNoDuplicatedCarNames(splitCarNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarName();
        }
        return splitCarNames;
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        int tryCount;
        try {
            tryCount = Integer.parseInt(input);
            validateNaturalNumber(tryCount);
        } catch (NumberFormatException e) {
            System.out.println(MESSAGE_ONLY_NUMBER);
            return getTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }
        return tryCount;
    }

    private void validateNaturalNumber(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(MESSAGE_ONLY_NATURAL_NUMBER);
        }
    }

    private void validateNoDuplicatedCarNames(List<String> carNames) {
        long distinctCarCount = carNames.stream()
                .distinct()
                .count();
        if (distinctCarCount != carNames.size()) {
            throw new IllegalArgumentException(MESSAGE_NO_DUPLICATE_CAR_NAMES);
        }
    }

    private void validateLengthOfCarNames(List<String> splitCarNames) {
        for (String carName : splitCarNames) {
            validateLengthOfCarName(carName);
        }
    }

    private void validateLengthOfCarName(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(MESSAGE_LENGTH_OF_CAR_NAME);
        }
    }

    private List<String> getSplitCarNames(String input) {
        return List.of(input.split(","));
    }

    private void validateNoSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(MESSAGE_NO_SPACE);
        }
    }
}
