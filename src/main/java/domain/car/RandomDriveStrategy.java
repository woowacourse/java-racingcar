package domain.car;

import java.util.function.IntSupplier;

public class RandomDriveStrategy implements DriveStrategy {
    private static final int MIN_POWER = 0;
    private static final int MAX_POWER = 9;
    private static final int POWER_THRESHOLD = 4;
    private static final int DRIVE_FORWARD_DISTANCE = 1;
    private static final int NO_DRIVE_DISTANCE = 0;

    private final IntSupplier powerGenerator;

    public RandomDriveStrategy(IntSupplier powerGenerator) {
        this.powerGenerator = powerGenerator;
    }

    @Override
    public int drive() {
        int power = powerGenerator.getAsInt();

        if (power >= POWER_THRESHOLD) {
            return DRIVE_FORWARD_DISTANCE;
        }

        return NO_DRIVE_DISTANCE;
    }

    // TODO: 스태틱 메소드 다른 처리 고민
    public static int generateRandomPower() {
        return (int) (Math.random() * (MAX_POWER - MIN_POWER + 1) + MIN_POWER);
    }
}
