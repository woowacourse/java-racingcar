package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVING_TRIAL_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";
    private static final String REGEX = "^[0-9]+$";
    private static final int MINIMUM_LENGTH_OF_MOVING_TRIAL = 1;
    private static final int MAXIMUM_LENGTH_OF_MOVING_TRIAL = 100;
    private static final String NOT_INTEGER_ERROR = "[ERROR] 숫자만 가능합니다.";
    private static final String MOVING_TRIAL_RANGE_ERROR = "[ERROR] 시도할 횟수의 범위는 1이상 100이하만 가능합니다.";


    public String readInput() throws IOException {
        return readLine();
    }

    public List<String> readCarNames() throws IOException {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        try {
            String inputName = readInput();
            String[] names = inputName.split(COMMA);
            return Arrays.asList(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }

    public int readMovingTrial() throws IOException {
        System.out.println(MOVING_TRIAL_INPUT_MESSAGE);
        try {
            String input = readInput();
            validateInteger(input);
            int movingTrial = Integer.parseInt(input);
            validateTrialRange(movingTrial);
            return movingTrial;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMovingTrial();
        }
    }

    private void validateTrialRange(int movingTrial) {
        if (movingTrial < MINIMUM_LENGTH_OF_MOVING_TRIAL || movingTrial > MAXIMUM_LENGTH_OF_MOVING_TRIAL) {
            throw new IllegalArgumentException(MOVING_TRIAL_RANGE_ERROR);
        }
    }

    private void validateInteger(String movingTrial) {
        if (!movingTrial.matches(REGEX)) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }
    }

    public String readLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        return bufferedReader.readLine();
    }
}
