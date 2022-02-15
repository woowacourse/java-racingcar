package racingcar.service.picker;

import java.util.Random;

public enum RandomRange {

    INCLUSIVE_START(0),
    EXCLUSIVE_END(10),
    SIZE(INCLUSIVE_START.number - EXCLUSIVE_END.number);

    private final int number;

    RandomRange(int number) {
        this.number = number;
    }

    public static int pick(Random random) {
        return random.nextInt(SIZE.number) + INCLUSIVE_START.number;
    }

}
