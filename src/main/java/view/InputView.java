package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD

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
=======
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
>>>>>>> 984262c (feat: 자동차 이름 입력)
            return readLine();
        }
    }
}
