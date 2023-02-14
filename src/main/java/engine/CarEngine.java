package engine;

import domain.Car;
import domain.Cars;
import utils.NumberGenerator;

public class CarEngine {

    private final NumberGenerator numberGenerator;

    public CarEngine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void moveCar(Cars cars) {
        for (Car car : cars.getCars()) {
            doRace(car);
        }
    }

    private boolean canMove() {
        return numberGenerator.generateNumber() >= 4;
    }

    private void doRace(final Car car) {
        if (canMove()) {
            car.move();
        }
    }
}
