package view;

import message.Exception;
import message.PrintMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView implements AutoCloseable {
    private static final String DELIMITER = ",";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    private final BufferedReader reader;

    public InputView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<String> inputCarsName() {
        System.out.println(PrintMessage.INPUT_CAR_NAMES.getMessage());
        String input;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        validateNotNullAndBlank(input);
        return Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
    }

    private void validateNotNullAndBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(Exception.INPUT_NULL_BLANK.getMessage());
        }
    }

    public int inputTrialCount() {
        System.out.println(PrintMessage.INPUT_TRIAL_COUNT.getMessage());
        String input;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(Exception.INPUT_NUMERIC.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
