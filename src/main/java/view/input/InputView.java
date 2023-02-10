package view.input;

import static validation.CarNameValidator.CAR_NAME_VALIDATOR;
import static validation.CountValidator.COUNT_VALIDATOR;
import static validation.InputValidator.INPUT_VALIDATOR;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    private String readLine() {
        return scanner.nextLine().strip();
    }

    public List<String> readCarNames() throws IllegalArgumentException {
        final String DELIMITER = ",";
        String input = readLine();
        INPUT_VALIDATOR.validate(input);
        List<String> carNames = splitWordsBy(input, DELIMITER);
        carNames.forEach(CAR_NAME_VALIDATOR::validate);
        return carNames;
    }

    public int readCount() throws IllegalArgumentException {
        String input = readLine();
        COUNT_VALIDATOR.validate(input);
        return Integer.parseInt(input);
    }

    private List<String> splitWordsBy(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, -1)).map(String::strip)
            .collect(Collectors.toList());
    }
}
