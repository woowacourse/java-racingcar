package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnersResult;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream().map(Car::of).collect(toList());
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.move(randomNumberGenerator.getRandomNumber()));
    }

    public MidtermResult getMidtermResult() {
        return new MidtermResult(cars);
    }

    public WinnersResult getWinnersResult() {
        return new WinnersResult(getWinners(getMostFarPosition()));
    }

    private List<Car> getWinners(final int mostFarPosition) {
        return cars.stream().filter(c -> c.isSamePosition(mostFarPosition)).collect(toList());
    }

    private int getMostFarPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().getAsInt();
    }
}
