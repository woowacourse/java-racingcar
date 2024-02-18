package view;

import common.Exception;
import common.Information;

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

    public List<String> inputCarsName() throws IOException {
        System.out.println(Information.INPUT_CAR_NAMES.getMessage());
        String input = reader.readLine();
        validateNotNullAndBlank(input);
        return Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
    }

    private void validateNotNullAndBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(Exception.INPUT_NULL_BLANK.getMessage());
        }
    }

    public int inputTrialCount() throws IOException {
        System.out.println(Information.INPUT_TRIAL_COUNT.getMessage());
        String input = reader.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(Exception.INPUT_NUMERIC.getMessage());
        }
    }

    @Override
    public void close() throws java.lang.Exception {
        reader.close();
    }
}
