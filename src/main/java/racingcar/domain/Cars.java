package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<Name> names) {
        for (Name name : names) {
            cars.add(new Car(name, Position.ZERO));
        }
    }

    public Cars(final List<Name> names, final List<Position> positions) {
        IntStream.range(0, names.size())
            .forEach(i -> cars.add(new Car(names.get(i), positions.get(i))));
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        List<Car> winners = new ArrayList<>();

        cars.stream()
            .filter(it -> it.isWinner(maxDistance))
            .forEach(winners::add);
        return winners;
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomUtils.getRandomNumber());
            OutputView.printCarInformation(car);
        }
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

}


