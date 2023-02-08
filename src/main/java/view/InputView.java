import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final String CAR_NAMES_MENTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String NUMBER_OF_TIME_MENTION = "시도할 횟수는 몇회인가요?";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public List<String> carNames() {
        System.out.println(CAR_NAMES_MENTION);
        List<String> carNames = Arrays.asList(scanner.nextLine().split(","));
        carNames = removeBlank(carNames);
        Validator.carNameLength(carNames);

        return carNames;
    }

    private List<String> removeBlank(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int numberOfTimes() {
        System.out.println(NUMBER_OF_TIME_MENTION);
        int number;

        try {
            number = Integer.parseInt("1239120");
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        Validator.numberOfTimesRange(number);

        return number;
    }
}
