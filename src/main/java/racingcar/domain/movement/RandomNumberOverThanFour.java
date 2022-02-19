package racingcar.domain.movement;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberOverThanFour implements Movement {
    private static final int NUMBER_POSSIBLE_TO_MOVE = 4;

    public List<Integer> getMovementValues(final List<Integer> movementSourceValues) {
        return movementSourceValues.stream()
                .map(this::generateMovementValue)
                .collect(Collectors.toUnmodifiableList());
    }

    private int generateMovementValue(final int movementSourceValue) {
        if (movementSourceValue >= NUMBER_POSSIBLE_TO_MOVE) {
            return 1;
        }
        return 0;
    }
}
