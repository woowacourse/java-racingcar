package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";
    private final BufferedReader reader;

    public InputView(final InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String[] readCarNames() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String userInput = removeBlank(reader.readLine());

        validateCarNamesFormat(userInput);

        return userInput.split(CAR_NAME_DELIMITER);
    }

    public Integer readNumberOfAttempts() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        final String userInput = removeBlank(reader.readLine());

        validateNumberOfAttempts(userInput);

        return Integer.parseInt(userInput);
    }

    private void validateCarNamesFormat(final String names) {
        if (!Pattern.matches("^[A-z0-9,]+$", names)) {
            throw new IllegalArgumentException("형식에 맞게 다시 입력하세요.\n");
        }
    }

    private void validateNumberOfAttempts(final String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1부터 10 이하의 숫자를 입력하세요.\n");
        }
    }

    private String removeBlank(final String text) {
        if (text == null) {
            return null;
        }
        return text.replaceAll(" ", "");
    }
}
