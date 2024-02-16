package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public static String inputRacingCars() {
        OutputView.printRequestCarNamesMessage();
        try {
            return CONSOLE.readLine();
        } catch(IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String inputTryCount() {
        OutputView.printRequestTryCountMessage();
        try {
            return CONSOLE.readLine();
        } catch(IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
