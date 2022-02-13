package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.utils.numbergenerator.NumberGenerator;
import racingcar.utils.numbergenerator.RandomNumberGenerator;

public class Cars {

    private static final String LIST_JOIN_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";
    private static final int MIN_COUNT = 2;
    private static final int MAX_COUNT = 5;
    private static final String ERROR_CAR_COUNT = "[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.";
    private static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름입니다.";

    private final List<Car> cars;
    private final List<String> winners;

    public Cars() {
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public Cars(String[] names) {
        validateCarCount(names);
        validateDuplicateName(names);

        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();

        for (String name : names) {
            this.addCar(new Car(name));
        }
    }

    private void validateCarCount(String[] names) {
        if (names.length > MAX_COUNT || names.length < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }
    }

    private void validateDuplicateName(String[] names) {
        Set<String> tempNameSet = new HashSet<>();
        for (String name : names) {
            tempNameSet.add(name);
        }

        if (tempNameSet.size() < names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCars() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (Car car : cars) {
            car.goForward(randomNumberGenerator);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();
        addWinnerNames(maxPosition);
        return String.join(LIST_JOIN_DELIMITER, winners) + WINNER_MESSAGE;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    private void addWinnerNames(int maxPosition) {
        for (Car car : cars) {
            addWinner(maxPosition, car);
        }
    }

    private void addWinner(int maxPosition, Car car) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car + "\n");
        }
        return stringBuilder.toString();
    }
}
