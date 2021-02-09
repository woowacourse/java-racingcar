package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        this(carNames, new int[carNames.length]);
    }

    public Cars(String[] carNames, int[] distance) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], distance[i]));
        }
    }

    public List<Car> getCars() {
        return cars;
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


