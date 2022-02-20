package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.util.Validator;

public class InputView {
    private static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_ROUND_VALUE = "시도할 회수는 몇회인가요?";
    private static final String SPLIT_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getInput() {
        return SCANNER.nextLine();
    }

    public static List<String> getCarNames() {
        OutputView.printRequestInstruction(REQUEST_CARS_NAME);
        List<String> carsName = Arrays.stream(getInput().split(SPLIT_DELIMITER, -1))
                .map(String::trim)
                .collect(Collectors.toList());
        Validator.validateCarNames(carsName);
        return carsName;
    }

    public static String getRound() {
        OutputView.printRequestInstruction(REQUEST_ROUND_VALUE);
        String inputRound = InputView.getInput();
        Validator.validateInputNumber(inputRound);
        return inputRound;
    }
}
