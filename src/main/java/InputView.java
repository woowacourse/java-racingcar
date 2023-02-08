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

        if (!isCorrectLength(carNames)) {
            throw new IllegalArgumentException("자동차명은 1 ~ 5 글자로 입력해야합니다.");
        }

        return carNames;
    }

    private boolean isCorrectLength(List<String> carNames) {
        return carNames.stream()
                .allMatch(carName -> 1 <= carName.length() && carName.length() <= 5);
    }

    private List<String> removeBlank(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public String numberOfTimes() {
        System.out.println(NUMBER_OF_TIME_MENTION);
        String number = scanner.nextLine();
        return "";
    }
}
