package racingCar;

import utils.RandomUtils;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 9;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Name> findWinners(int maxDistance) {
        return cars.stream()
                .filter(car -> car.isWinner(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int findMaxDistance() {
        int maxNumber = 0;
        for (Car car : cars) {
            maxNumber = Math.max(maxNumber, car.getDistance());
        }
        return maxNumber;
    }

    public void moveCar() {
        for (Car car : cars) {
            car.move(RandomUtils.nextInt(MINIMUM_VALUE, MAXIMUM_VALUE));
        }
    }


}
