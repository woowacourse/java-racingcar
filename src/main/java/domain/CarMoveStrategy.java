package domain;

import java.util.function.IntSupplier;


public class CarMoveStrategy{

    public static final int MAX_MOVABLE_DIGIT = 4;

    private final IntSupplier supplier;

    public CarMoveStrategy(IntSupplier supplier) {
        this.supplier = supplier;
    }

    public boolean isMove() {
        return supplier.getAsInt() >= MAX_MOVABLE_DIGIT;
    }
}
