package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readCarNames(OutputView outputView) {
        outputView.printInputCarNamesGuide();
        return readLine();
    }

    public String readNumberOfTry(OutputView outputView) {
        outputView.readNumberOfTry();
        return readLine();
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException ioException) {
            return readLine();
        }
    }
}
