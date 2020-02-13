package racingcargame.domain;

import racingcargame.genrator.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getMaxPosition() {
        int result = 0;
        for (Car car : cars) {
            if (car.getPosition() > result) {
                result = car.getPosition();
            }
        }
        return result;
    }

    public List<String> getCarNamesInSamePositionWith(int position) {
        return cars.stream()
                .filter(car -> car.isSamePositionWith(position))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getCarNamesInMaxPosition() {
        return getCarNamesInSamePositionWith(getMaxPosition());
    }

    public void moveFoward(int round) {
        for (int i = 0; i < round; i++) {
            moveOneRound();
        }
    }

    private void moveOneRound() {
        for (Car car : cars) {
            car.move(RandomGenerator.generateRandom());
        }
    }
}
