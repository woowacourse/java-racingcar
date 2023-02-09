package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String READ_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;

    private final InputValidator inputValidator;
    private final BufferedReader reader;

    public InputView(final InputValidator inputValidator, final BufferedReader reader) {
        this.inputValidator = inputValidator;
        this.reader = reader;
    }

    public List<String> readCarNames() throws IOException {
        System.out.println(READ_NAMES_MESSAGE);
        String input = reader.readLine();
        List<String> names = generateNames(input);
        inputValidator.validateNames(names);
        return names;
    }

    private List<String> generateNames(final String input) {
        return Arrays.stream(input.split(DELIMITER, SPLIT_LIMIT))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
