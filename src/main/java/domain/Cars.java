package domain;

import utils.RandomUtil;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car>{
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            tryMove(car);
        }
    }

    private void tryMove(Car car) {
        int randomNumber = RandomUtil.createRandomNumber();

        if (RandomUtil.canMoveForward(randomNumber)) {
            car.move();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getCurrentState() + "\n");
        }

        return stringBuilder.toString();
    }

    public Cars getWinners() {
        Integer maxPosition = getMaxPosition();
        List<Car> result = cars.stream()
                .filter(m -> m.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return new Cars(result);
    }

    private Integer getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .get();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
