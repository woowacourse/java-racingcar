package racingcar.domain;

import racingcar.domain.factory.CarFactory;

import java.util.List;

public class RacingCarGame {

    private static final int START_POSITION = 0;

    public void addCars(String carNames) {
        CarRepository.updateCars(CarFactory.from(carNames));
    }

    public void race(Movement movement) {
        for (Car car : CarRepository.findAll()) {
            car.move(movement);
        }
    }

    public List<String> getWinners() {
        return CarRepository.findMaxPosition(getMaxPosition());
    }

    private int getMaxPosition() {
        return CarRepository.findAll().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(START_POSITION);
    }
}
