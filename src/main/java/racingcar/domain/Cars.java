package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnersResult;

public class Cars {

    private static final int FORWARD_BOUNDARY_NUMBER = 4;

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream()
                .map(Car::of)
                .collect(toList());
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            moveOneCar(randomNumberGenerator, car);
        }
    }

    private void moveOneCar(RandomNumberGenerator randomNumberGenerator, Car car) {
        if (isAvailableMove(randomNumberGenerator)) {
            car.forwardCarPosition();
        }
    }

    private boolean isAvailableMove(RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.getRandomNumber() >= FORWARD_BOUNDARY_NUMBER;
    }

    public MidtermResult getMidtermResult() {
        return new MidtermResult(cars);
    }

    public WinnersResult getWinnersResult() {
        return new WinnersResult(getWinnerCars());
    }

    private List<Car> getWinnerCars() {
        return cars.stream()
                .filter(c -> c.isSamePosition(getMostFarPosition()))
                .collect(toList());
    }

    private int getMostFarPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
