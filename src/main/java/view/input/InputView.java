package view.input;

import static validation.CarNameValidator.CAR_NAME_VALIDATOR;
import static validation.CountValidator.COUNT_VALIDATOR;
import static validation.InputValidator.INPUT_VALIDATOR;
import static validation.ParticipantsValidator.PARTICIPANTS_VALIDATOR;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final static String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String ENTER_COUNT = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        final String DELIMITER = ",";

        printInputMessage(ENTER_CAR_NAMES);
        String input = readLine();
        INPUT_VALIDATOR.validate(input);
        List<String> carNames = splitWordsBy(input, DELIMITER);
        carNames.forEach(CAR_NAME_VALIDATOR::validate);
        PARTICIPANTS_VALIDATOR.validate(carNames);
        return carNames;
    }

    public int readCount() throws IllegalArgumentException {
        printInputMessage(ENTER_COUNT);
        String input = readLine();
        COUNT_VALIDATOR.validate(input);
        return Integer.parseInt(input);
    }

    private String readLine() {
        return scanner.nextLine().strip();
    }

    private void printInputMessage(String message) {
        System.out.println(message);
    }

    private List<String> splitWordsBy(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, -1)).map(String::strip)
            .collect(Collectors.toList());
    }
}
