package model;

import java.util.Random;

public class Racing {
    private static final int RANDOM_BOUND = 10;
    private static Random random = new Random();
    private Cars cars;
    private LapCount lapCount;
    private LapRecord lapRecord;

    public Racing(Cars cars, LapCount lapCount) {
        this.cars = cars;
        this.lapCount = lapCount;
        this.lapRecord = new LapRecord();
    }

    public LapRecord run() {
        for (int lapNo = 1; lapNo <= lapCount.getLapCount(); lapNo++) {
            runLap();
            lapRecord.add(cars.copy());
        }

        return lapRecord;
    }

    private void runLap() {
        for (Car car : cars.getCars()) {
            car.move(random.nextInt(RANDOM_BOUND));
        }
    }
}
