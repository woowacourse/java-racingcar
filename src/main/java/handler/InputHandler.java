package handler;

import java.io.IOException;

import domain.RacingGame;
import view.InputView;

//TODO: 하드코딩된 값 제거
//TODO: 예외 발생 시 재입력
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
        String input = inputView.readMovingTrial();
        validateInteger(input);
        int movingTrial = Integer.parseInt(input);
        validateTrialRange(movingTrial);

        return movingTrial;
    }

    private void validateTrialRange(int movingTrial) {
        if (movingTrial < 1 || movingTrial > 100) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수의 범위는 1이상 100이하만 가능합니다.");
        }
    }

    private void validateInteger(String movingTrial) {
        //TODO: 예외 메시지
        if (!movingTrial.matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자만 가능합니다.");
        }
    }
}
