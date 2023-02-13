package view;

import util.CarNameValidator;
import util.RepeatCountValidator;
import util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String NUMBER_OF_TIME_HEADER = "시도할 횟수는 몇회인가요?";
    public static final String CAR_NAMES_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final Scanner console;
    private final Validator carNameValidator;
    private final Validator repeatCountValidator;

    public InputView() {
        console = new Scanner(System.in);
        carNameValidator = new CarNameValidator();
        repeatCountValidator = new RepeatCountValidator();
    }

    public List<String> getCarNames() {
        System.out.println(CAR_NAMES_HEADER);
        List<String> carNames = Arrays.asList(console.nextLine().split(DELIMITER, -1));
        List<String> trimCarNames = trimCarNames(carNames);

        carNameValidator.validate(trimCarNames);

        return trimCarNames;
    }

    private List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int getTryCount() {
        System.out.println(NUMBER_OF_TIME_HEADER);
        String number = console.nextLine();

        repeatCountValidator.validate(number);

        return Integer.parseInt(number);
    }
}
