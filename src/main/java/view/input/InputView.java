package view.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    private String readLine() {
        return scanner.nextLine();
    }

    public List<String> readCarNames() throws IllegalArgumentException {
        final String DELIMITER = ",";
        String input = readLine();
        Validator.isNotEmpty(input);
        List<String> carNames = splitWordsBy(input, DELIMITER);
        Validator.isProperCarNames(carNames);
        return carNames;
    }

    private List<String> splitWordsBy(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, -1)).map(String::strip)
            .collect(Collectors.toList());
    }
}
