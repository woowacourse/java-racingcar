package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private final BufferedReader reader;

    public InputView(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }


    public List<String> readCarNames() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String inputData = removeBlank(reader.readLine());
        validateCarNamesFormat(inputData);
        return Arrays.stream(inputData.split(","))
                .collect(Collectors.toList());
    }

    private void validateCarNamesFormat(String names) {
        if (!Pattern.matches("^[A-z0-9,]+$", names)) {
            throw new IllegalArgumentException("형식에 맞게 다시 입력하세요.");
        }
    }

    public Integer readNumberOfAttempts() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        final String inputData = removeBlank(reader.readLine());
        validateNumberOfAttempts(inputData);
        return Integer.parseInt(inputData);
    }

    private void validateNumberOfAttempts(String text) {
        try {
            int numberOfAttempts = Integer.parseInt(text);
            validateRange(numberOfAttempts, 1, 10);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int target, int start, int end) {
        if (target < start || target > end) {
            throw new IllegalArgumentException("1부터 10 이하의 숫자를 입력하세요. ");
        }
    }

    private String removeBlank(String text) {
        return text.replaceAll(" ", "");
    }
}
