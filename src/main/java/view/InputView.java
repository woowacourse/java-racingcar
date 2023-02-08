package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

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
        outputView.readNumberOfTry();
        return Integer.parseInt(readLine());
    }

    private String readLine() {
        // TODO : 안내 문구 출력 메서드로 돌아가기
        try {
            return bufferedReader.readLine();
        } catch (IOException ioException) {
            outputView.printException(ioException);
            return readLine();
        }
    }
}
