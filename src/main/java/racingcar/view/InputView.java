package racingcar.view;

import racingcar.enumType.ExceptionMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String getUserInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(String.format(ExceptionMessage.INPUT_MESSAGE.getValue(), e.getMessage()));
        }
    }
}
