import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static String MESSAGE_NO_DUPLICATE_CAR_NAMES = "중복된 자동차 이름은 사용할 수 없습니다.";
    private final static String MESSAGE_LENGTH_OF_CAR_NAME = "자동차 이름은 1자 이상 5자 이하여야 합니다.";
    private final static String MESSAGE_NO_SPACE = "중복된 자동차 이름은 사용할 수 없습니다.";
    private final Scanner scanner = new Scanner(System.in);
    private final OutputView outputView;


    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<String> getCarName() {
        outputView.printCarNameInputMessage();
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

    private void validateNoDuplicatedCarNames(List<String> splitCarNames) {
        long distinctCarCount = splitCarNames.stream()
                .distinct()
                .count();
        if (distinctCarCount != splitCarNames.size()) {
            throw new IllegalArgumentException(MESSAGE_NO_DUPLICATE_CAR_NAMES);
        }
    }

    private void validateLengthOfCarNames(List<String> splitCarNames) {
        for (String carName : splitCarNames) {
            validateLengthOfCarName(carName);
        }
    }

    private void validateLengthOfCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
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

    public int getTryCount() {
        outputView.printTryCountInputMessage();
        String input = scanner.nextLine();
        int tryCount;
        try {
            tryCount = Integer.parseInt(input);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도할 회수는 자연수를 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("시도할 회수는 숫자여야만 가능합니다.");
            return getTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }
        return tryCount;
    }
}
