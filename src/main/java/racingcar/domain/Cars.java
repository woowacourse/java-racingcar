package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<Name> names) {
        validateNames(names);
        for (Name name : names) {
            cars.add(new Car(name, Position.ZERO));
        }
    }

    public Cars(final List<Name> names, final List<Position> positions) {
        validateNames(names);
        IntStream.range(0, names.size())
            .forEach(i -> cars.add(new Car(names.get(i), positions.get(i))));
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();

        cars.stream()
            .filter(it -> it.isWinner(getMaxDistance()))
            .forEach(winners::add);
        return Collections.unmodifiableList(winners);
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

    private void validateNames(List<Name> names) {
        int originCount = names.size();
        Set<Name> set = new HashSet<>();

        for (Name name : names) {
            set.add(name);
        }
        if (originCount > set.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복이 불가능합니다.");
        }
    }

}


