package handler;

import java.io.IOException;

import domain.RacingGame;
import view.InputView;

public class InputHandler {

    private static final String COMMA = ",";
    private static final String REGEX = "^[0-9]+$";
    private static final int MINIMUM_LENGTH_OF_MOVING_TRIAL = 1;
    private static final int MAXIMUM_LENGTH_OF_MOVING_TRIAL = 100;
    private static final String MOVING_TRIAL_NOT_INTEGER_ERROR = "[ERROR] 시도할 횟수는 숫자만 가능합니다.";
    private static final String MOVING_TRIAL_RANGE_ERROR = "[ERROR] 시도할 횟수의 범위는 1이상 100이하만 가능합니다.";

    private final InputView inputView;

    public InputHandler() {
        this.inputView = new InputView();
    }

    public String[] readCarNames() throws IOException {
        try {
            String inputName = inputView.readCarNamesInput();
            String[] names = inputName.split(COMMA);

            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }

    public int readMovingTrial() throws IOException {
        try {
            String input = inputView.readMovingTrial();
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
            throw new IllegalArgumentException(MOVING_TRIAL_NOT_INTEGER_ERROR);
        }
    }
}
