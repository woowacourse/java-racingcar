package racingcar.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.Constant;

public class Cars {

    private static final int MINIMUM_MOVE = 4;
    private static final int RANDOM_RANGE = 10;

    List<Car> cars;

    public Cars(List<Car> cars) {
        checkDuplicate(cars);
        this.cars = cars;

    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = findWinnerByPosition(maxPosition, cars);
        return winners;
    }

    public void move() {

        for (Car car : cars) {
//            RandomMoveCondition randomMoveCondition = new RandomMoveCondition();
//            car.movePosition(randomMoveCondition);
            car.movePosition(() -> makeRandom() >= MINIMUM_MOVE);
            //car.movePosition(randomMoveCondition);
        }
    }

    private int makeRandom() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    private int findMaxPosition(List<Car> cars) {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

        return cars.stream()
            .max(comparatorByPosition).get().getPosition();
    }

    private List<String> findWinnerByPosition(int maxPosition, List<Car> cars) {
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }


    private void checkDuplicate(List<Car> cars) {
        Set<String> uniqueNames = new HashSet<>(cars.stream().map(Car::getName).collect(Collectors.toList()));
        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NAME_ERROR);
        }
    }




}
