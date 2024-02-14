package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String inputRacingCars() throws IOException {
        OutputView.printRequestCarNamesMessage();
        return br.readLine();
    }

    public static String inputTryCount() throws IOException {
        OutputView.printRequestTryCountMessage();
        return br.readLine();
    }
}
