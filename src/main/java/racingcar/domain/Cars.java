package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static final String LIST_JOIN_DELIMITER = ", ";
    public static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";

    private final List<Car> cars;
    private final List<String> winners;

    public Cars() {
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public Cars(String[] values) {
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();

        for (String value : values) {
            this.addCar(new Car(value));
        }
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
