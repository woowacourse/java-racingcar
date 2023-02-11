package view;

import utils.NumberValidator;
import utils.StringParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputView {

    private static final String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readCarNames() throws IOException {
        System.out.println(READ_CAR_NAME_MESSAGE);
        String input = bufferedReader.readLine();
        return StringParser.splitByComma(input);
    }

    public static int readAttemptNumber() throws IOException {
        try {
            System.out.println(READ_ATTEMPT_NUMBER_MESSAGE);
            String input = bufferedReader.readLine();
            return NumberValidator.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAttemptNumber();
        }
    }
}
