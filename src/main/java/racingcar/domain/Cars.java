package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.game.RandomNumberGenerator;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnerResult;

public class Cars {

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public Cars(List<String> names, RandomNumberGenerator randomNumberGenerator) {
        cars = names.stream()
            .map(Car::createByName)
            .collect(toList());
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void move() {
        cars.forEach(car -> car.move(randomNumberGenerator.getRandomNumber()));
    }

    public MidtermResult getMidtermResult() {
        return new MidtermResult(cars);
    }

    public WinnerResult getWinnerResult() {
        return new WinnerResult(getWinners(getMostFarPosition()));
    }

    private int getMostFarPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    private List<Car> getWinners(final int mostFarPosition) {
        return cars.stream()
            .filter(c -> c.isSamePosition(mostFarPosition))
            .collect(toList());
    }
}
