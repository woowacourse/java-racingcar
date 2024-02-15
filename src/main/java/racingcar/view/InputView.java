package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String inputNames() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    public static int inputMoveCount() {
        try {
            String moveCount = br.readLine();
            return Integer.parseInt(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        } catch (IOException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }
}

