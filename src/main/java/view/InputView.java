package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final OutputView outputView;
    private final BufferedReader bufferedReader;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readCarNames() {
        outputView.readCarNames();
        return readLine();
    }

    public int readNumberOfMoving() {
        try {
            outputView.readNumberOfTry();
            return Integer.parseInt(readLine());
        } catch (NumberFormatException numberFormatException) {
            outputView.printException("숫자만 입력할 수 있습니다.");
            return readNumberOfMoving();
        }
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException ioException) {
            outputView.printException(ioException.getMessage());
            return readLine();
        }
    }
}
