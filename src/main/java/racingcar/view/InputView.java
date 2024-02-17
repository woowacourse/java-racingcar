package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> inputRacingCars() {
        OutputView.printRequestCarNamesMessage();
        try {
            String inputCarNames = br.readLine();
            checkIfValidInput(inputCarNames);
            return parseWithComma(inputCarNames);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String inputTryCount() {
        OutputView.printRequestTryCountMessage();
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfValidInput(String input) {
        String regex = "^[^,]+(,[^,]+)*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> parseWithComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }
}
