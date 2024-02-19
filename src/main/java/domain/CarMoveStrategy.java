package domain;

import java.util.function.IntSupplier;

/**
 * MoveStrategy 를 구현할 필요가 있을까??
 */
public class CarMoveStrategy implements MoveStrategy{

    public static final int MAX_MOVABLE_DIGIT = 4;

    private final IntSupplier supplier;

    public CarMoveStrategy(IntSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean isMove() {
        return supplier.getAsInt() >= MAX_MOVABLE_DIGIT;
    }
}
