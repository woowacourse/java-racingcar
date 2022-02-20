package racingcargame.model.movementgenerator;

import racingcargame.model.movementgenerator.Move;
import racingcargame.model.numbergenerator.NumberGenerator;

public class MoveGenerator implements Move {
    private static final int MAX_BOUNDARY_NUMBER = 10;
    private static final int NUMBER_MAKE_MOVE_POSSIBLE = 4;

    private final NumberGenerator numberGenerator;

    public MoveGenerator(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public int getMoveValue() {
        int randomNumber = numberGenerator.generateNumber(MAX_BOUNDARY_NUMBER);
        if (randomNumber > NUMBER_MAKE_MOVE_POSSIBLE) {
            return 1;
        }
        return 0;
    }
}
