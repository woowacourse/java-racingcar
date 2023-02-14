package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.RandomPowerGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(i -> i.getCarName())
                .collect(Collectors.toList());

        Set<String> carNameWithoutDuplication = new HashSet<>(carNames);

        if (carNameWithoutDuplication.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야합니다.");
        }
    }

    public void moveAll(final RandomPowerGenerator randomPowerGenerator) {
        for (final Car car : cars) {
            final int power = randomPowerGenerator.generateRandomPower();
            car.move(power);
        }
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        final int maxCountOfDistance = findMaxCountOfDistance();

        for (final Car car : cars) {
            addWinnerName(winnerNames, car, maxCountOfDistance);
        }

        return winnerNames;
    }

    private int findMaxCountOfDistance() {
        int maxCountOfDistance = Integer.MIN_VALUE;

        for (final Car car : cars) {
            maxCountOfDistance = Math.max(car.getDistance(), maxCountOfDistance);
        }

        return maxCountOfDistance;
    }

    private void addWinnerName(final List<String> winnerNames, final Car car, final int maxCountOfDistance) {
        if (car.getDistance() == maxCountOfDistance) {
            winnerNames.add(car.getCarName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
