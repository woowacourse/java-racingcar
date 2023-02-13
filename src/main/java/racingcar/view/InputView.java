package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return readLine();
    }

    public String readNumberOfTry() {
        System.out.println("시도할 회수는 몇회인가요?");
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
