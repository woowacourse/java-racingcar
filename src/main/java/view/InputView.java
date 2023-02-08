package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

import static constant.Constants.NOT_NUMERIC_EXCEPTION;

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
            outputView.printException(NOT_NUMERIC_EXCEPTION);
            return readNumberOfMoving();
        }
    }

    private String readLine() {
        // TODO : 안내 문구 출력 메서드로 돌아가기
        try {
            return bufferedReader.readLine();
        } catch (IOException ioException) {
            outputView.printException(ioException.getMessage());
            return readLine();
        }
    }
}
