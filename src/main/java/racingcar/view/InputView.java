package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {
        throw new IllegalStateException("생성할 수 없는 유틸 클래스입니다.");
    }

    public static String readCarNames() {
        return readLine();
    }

    public static String readNumberOfTry() {
//        outputView.printException("숫자만 입력할 수 있습니다.");
        return readLine();
    }

    private static String readLine() {
        try {
            return BUFFERED_READER.readLine();
        } catch (IOException ioException) {
//            outputView.printException(ioException.getMessage());
            return readLine();
        }
    }
}
