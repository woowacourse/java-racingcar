package view;

import util.Validator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String NUMBER_OF_TIME_HEADER = "시도할 횟수는 몇회인가요?";
    public static final String CAR_NAMES_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private Scanner console;

    public InputView(InputStream consoleConnector) {
        console = new Scanner(consoleConnector);
    }

    public List<String> carNames() {
        System.out.println(CAR_NAMES_HEADER);
        List<String> carNames = Arrays.asList(console.nextLine().split(DELIMITER));
        carNames = trimCarNames(carNames);
        Validator.carNames(carNames);

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
        Validator.numberOfTimes(number);

        return Integer.parseInt(number);
    }
}
