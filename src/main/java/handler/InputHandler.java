package handler;

import java.io.IOException;

import domain.RacingGame;
import view.InputView;

public class InputHandler {

    private static final String REGEX = "^[0-9]+$";

    private final InputView inputView;

    public InputHandler() {
        this.inputView = new InputView();
    }

    public RacingGame readCars() throws IOException {
        String inputName = inputView.readCarNames();
        String[] names = inputName.split(",");

        return new RacingGame(names);
    }

    public int readMovingTrial() throws IOException {
        String movingTrial = inputView.readMovingTrial();
        validateInteger(movingTrial);

        return Integer.parseInt(movingTrial);
    }

    private void validateInteger(String movingTrial) {
        //TODO: 예외 메시지
        if (!movingTrial.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }
}
