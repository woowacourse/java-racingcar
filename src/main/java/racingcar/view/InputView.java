package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String NAME_INPUT_DESCRIPTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String DELIMITER = ",";
    public String[] inputNames() throws IOException {
        System.out.printf(NAME_INPUT_DESCRIPTION);
        String rawNames = br.readLine();
        return rawNames.split(DELIMITER);
    }
}
