package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVING_TRIAL_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String readCarNamesInput() throws IOException {
        System.out.println(CAR_NAME_INPUT_MESSAGE);

        return readLine();
    }

    public String readMovingTrial() throws IOException {
        System.out.println(MOVING_TRIAL_INPUT_MESSAGE);

        return readLine();
    }

    public String readLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        return bufferedReader.readLine();
    }
}
