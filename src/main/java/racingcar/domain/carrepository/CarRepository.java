package racingcar.domain.carrepository;

import racingcar.domain.car.Car;
import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.List;

public class CarRepository {

    private final List<Car> repository;

    public CarRepository(List<Car> repository) {
        this.repository = repository;
    }

    public void movePosition() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (Car car : repository) {
            int randomNumber = numberGenerator.generateRandomNumber();
            judgeMovement(randomNumber, car);
        }
    }

    private void judgeMovement(int randomNumber, Car car) {
        if (randomNumber >= 4) {
            car.updatePosition();
        }
    }
}
