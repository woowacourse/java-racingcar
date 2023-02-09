package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class InputView {

    private static final String READ_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final InputValidator inputValidator;
    private final BufferedReader reader;

    public InputView(final InputValidator inputValidator, final BufferedReader reader) {
        this.inputValidator = inputValidator;
        this.reader = reader;
    }

    public List<String> readCarNames() throws IOException {
        System.out.println(READ_NAMES_MESSAGE);
        String input = reader.readLine();
        return inputValidator.validateNames(input);
    }

    public int readCount() throws IOException {
        System.out.println(READ_COUNT_MESSAGE);
        String input = reader.readLine();
        return inputValidator.validateCount(input);
    }
}
