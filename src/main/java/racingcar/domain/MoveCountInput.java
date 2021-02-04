package racingcar.domain;

import racingcar.exception.CarMoveCountNonNumericException;

public class MoveCountInput {

    public MoveCountInput(String input) {
        validateMoveCountInputNumeric(input);
    }

    private void validateMoveCountInputNumeric(String input) {
        if (!isNumeric(input)) {
            throw new CarMoveCountNonNumericException();
        }
    }

    private boolean isNumeric(String input) {
        return input.replaceAll(" ","").chars().allMatch(Character::isDigit);
    }
}
