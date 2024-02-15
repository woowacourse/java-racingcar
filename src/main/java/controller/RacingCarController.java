package controller;

import domain.RacingCarNames;
import exception.NotNumberPositiveException;
import view.InputView;

public class RacingCarController {
    public void start() {
        RacingCarNames racingCarNames = readRacingCarNames();
        int moveCount = readMoveCount();
    }

    private RacingCarNames readRacingCarNames() {
            String carNames = InputView.inputCarNames();
            return new RacingCarNames(carNames);
    }

    private int readMoveCount() {
        String input = InputView.inputMoveCount();
        int moveCount = Integer.parseInt(input);
        validatePositiveMoveCount(moveCount);
        return moveCount;
    }

    private void validatePositiveMoveCount(int moveCount) {
        if (moveCount <= 0) {
            throw new NotNumberPositiveException();
        }
    }
}
