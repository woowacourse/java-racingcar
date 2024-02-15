package racingcar.config;

public enum RacingCarConfig {
    MAX_NAME_LENGTH(5),
    CAR_MOVE_THRESHOLD(4),
    MIN_CARS_SIZE(2),
    MAX_CARS_SIZE(10),
    MAX_RANDOM_NUMBER(9),
    MIN_TRY_COUNT(0),
    MAX_TRY_COUNT(1_000);

    private final int value;

    RacingCarConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
