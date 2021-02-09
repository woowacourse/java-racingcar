package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Name> names) {
        this(names, new int[names.size()]);
    }

    public Cars(List<Name> names, int[] distance) {
        for (int i = 0; i < names.size(); i++) {
            cars.add(new Car(names.get(i), distance[i]));
        }
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


