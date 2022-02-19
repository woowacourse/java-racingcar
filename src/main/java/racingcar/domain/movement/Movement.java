package racingcar.domain.movement;

import java.util.List;

public interface Movement {
    List<Integer> getMovementValues(final List<Integer> movementSourceValues);
}
