package domain.mock;

import domain.Movement;
import domain.MovementGenerator;

public class AlwaysMoveGenerator implements MovementGenerator {
    @Override
    public Movement generate() {
        return Movement.MOVE;
    }
}
