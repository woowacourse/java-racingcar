package racingcar.domain.movestrategy;

import java.util.function.IntSupplier;
import racingcar.domain.MoveStrategy;

public class CarMoveStrategy implements MoveStrategy {

    private static final int MIN_MOVABLE_DIGIT = 4;

    private final IntSupplier supplier;

    public CarMoveStrategy(final IntSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean isMove() {
        return supplier.getAsInt() >= MIN_MOVABLE_DIGIT;
    }
}
