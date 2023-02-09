package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import utils.CarNameValidator;
import utils.StringParser;

public class InputView {

    private static final String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private BufferedReader br;

    public InputView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<String> readCarName() throws IOException {
        try {
            System.out.println(READ_CAR_NAME_MESSAGE);
            String input = br.readLine();
            List<String> carNames = StringParser.parse(input);
            validate(carNames);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCarName();
        }
    }

    private void validate(List<String> carNames) {
        for (String carName : carNames) {
            CarNameValidator.validate(carName);
        }
    }

    public int readAttemptNumber() throws IOException {
        System.out.println(READ_ATTEMPT_NUMBER_MESSAGE);
        return Integer.parseInt(br.readLine());
    }
}
