package racingcar.domain;

import java.util.function.IntSupplier;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MIN_MOVABLE_DIGIT = 4;

    private final IntSupplier supplier;

    public RandomMoveStrategy(IntSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean isMove() {
        return supplier.getAsInt() >= MIN_MOVABLE_DIGIT;
    }
}
