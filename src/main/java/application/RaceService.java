package application;

import model.Cars;
import util.NumberGenerator;

public class RaceService {
    private static final int MOVE_THRESHOLD = 4;
    private final NumberGenerator numberGenerator;

    public RaceService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void moveCars(Cars cars) {
        cars.getCars()
                .forEach(car -> {
                    int number = numberGenerator.generateNumber();
                    if (number >= MOVE_THRESHOLD) {
                        car.moveForward();
                    }
                });
    }
}
