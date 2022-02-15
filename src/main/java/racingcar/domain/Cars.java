package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnersResult;

public class Cars {

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
        if (randomNumberGenerator.isMoveAvailable()) {
            car.forwardCarPosition();
        }
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
