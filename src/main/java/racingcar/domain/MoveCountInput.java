package racingcar.domain;

import racingcar.exception.CarMoveCountNegativeException;
import racingcar.exception.CarMoveCountNonNumericException;

public class MoveCountInput {

    int moveCount;

    public MoveCountInput(String input) {
        validateMoveCountInputNumeric(input);
        validateMoveCountPositive(input);

        this.moveCount = Integer.parseInt(input);
    }

    private void validateMoveCountInputNumeric(String input) {
        if (!isNumeric(input)) {
            throw new CarMoveCountNonNumericException();
        }
    }

    private void validateMoveCountPositive(String input) {
        if(Integer.parseInt(input) < 0) {
            throw new CarMoveCountNegativeException();
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
