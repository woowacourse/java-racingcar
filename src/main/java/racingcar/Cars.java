package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();
        List<String> names = addWinnerNames(maxPosition);
        return String.join(", ", names) + "가 최종 우승 했습니다.";
    }

    private List<String> addWinnerNames(int maxPosition) {
        List<String> names = new ArrayList<>();

        for (Car car : cars) {
            addName(maxPosition, names, car);
        }
        return names;
    }

    private void addName(int maxPosition, List<String> names, Car car) {
        if (car.isMaxPosition(maxPosition)) {
            names.add(car.getName());
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
