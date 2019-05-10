package racingcargame.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputView {
    private final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private final String COUNT_OF_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        try {
            String names = bufferedReader.readLine();
            return names;
        } catch (Exception e) {
            return readNames();
        }
    }

    public int readCountOfRound() {
        System.out.println(COUNT_OF_ROUND_INPUT_MESSAGE);
        try {
            int input = Integer.parseInt(bufferedReader.readLine());
            validNagetiveNumber(input);
            return input;
        } catch (Exception e) {
            return readCountOfRound();
        }
    }

    private void validNagetiveNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
    }
}
