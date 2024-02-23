package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import racingcar.utils.NameParser;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> inputNames() {
        try {
            return NameParser.parse(br.readLine());
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

