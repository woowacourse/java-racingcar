package racingcar.domain.game;

import java.util.Objects;

public class Lap {

    private static final int INIT_LAP_VALUE = 0;
    private static final int INCREASE_INTERVAL = 1;
    private static final int LEAST_TOTAL_LAP_COUNT = 1;
    private final int value;

    private Lap(final int value) {
        this.value = value;
    }

    public static Lap totalLap(final int value) {
        if (LEAST_TOTAL_LAP_COUNT > value) {
            throw new IllegalArgumentException(String.format("최소 바퀴 수는 %d 이상이어야 합니다.", LEAST_TOTAL_LAP_COUNT));
        }
        return new Lap(value);
    }

    public static Lap init() {
        return new Lap(INIT_LAP_VALUE);
    }

    public Lap increase() {
        return new Lap(this.value + INCREASE_INTERVAL);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Lap)) return false;
        Lap lap = (Lap) o;
        return value == lap.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int value() {
        return value;
    }
}
