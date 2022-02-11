package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static final String LIST_JOIN_DELIMITER = ", ";
    public static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";

    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public static Cars toCars(String[] values) {
        Cars cars = new Cars();
        for (String value : values) {
            cars.addCar(new Car(value));
        }
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.goForward();
        }
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();
        addWinnerNames(maxPosition);
        return String.join(LIST_JOIN_DELIMITER, winners) + WINNER_MESSAGE;
    }

    private void addWinnerNames(int maxPosition) {
        for (Car car : cars) {
            addName(maxPosition, car);
        }
    }

    private void addName(int maxPosition, Car car) {
        if (car.isMaxPosition(maxPosition)) {
            winners.add(car.getName());
        }
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
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
