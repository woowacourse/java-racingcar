package carracing.view;

import static carracing.view.messages.ExceptionMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String CAR_DELIMITER = ",";
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {
    }

    public static List<String> getCarNames() {
        String line = "";
        try {
            line = bufferedReader.readLine();
            validateEmptyString(line);
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e.getMessage());
            return getCarNames();
        }
        List<String> carNames = splitCarNames(line);
        return carNames;
    }

    private static List<String> splitCarNames(String readLine) {
        return Arrays.asList(readLine.split(CAR_DELIMITER));
    }

    public static int getNumberOfGames() {
        int numberOfGames = 0;
        try {
            String line = bufferedReader.readLine();
            validateEmptyString(line);
            numberOfGames = toInt(line);
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e.getMessage());
            return getNumberOfGames();
        }
        return numberOfGames;
    }

    private static void validateEmptyString(String line) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException(INPUT_EMPTY_STRING_EXCEPTION.getMessage());
        }
    }

    private static int toInt(String line) {
        validateNumber(line);
        return Integer.parseInt(line);
    }

    private static void validateNumber(String number) {
        if (!number.matches(NUMBER_REGEX) || Integer.parseInt(number) == 0) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER_EXCEPTION.getMessage());
        }
    }
}
