package domain;

import utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveCar() {
        for (final Car car : cars) {
            doRace(car);
        }
    }

    private void doRace(final Car car) {
        if (canMove()) {
            car.move();
        }
    }

    private boolean canMove() {
        return RandomNumberGenerator.generateRandomNumber() >= 4;
    }

    public List<String> getWinner() {
        List<String> result = new ArrayList<>();
        int max = getMaxDistance();

        for (final Car car : cars) {
            addWinner(result, car, max);
        }

        return result;
    }

    private int getMaxDistance() {
        int max = Integer.MIN_VALUE;
        for (final Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        return max;
    }

    private void addWinner(List<String> result, Car car, int max) {
        if (car.getDistance() == max) {
            result.add(car.getName());
        }
    }

    public String getCurrentStatus() {
        StringBuilder stringBuilder = new StringBuilder();

        for (final Car car : cars) {
            stringBuilder.append(car.getName()).append(" : ");
            stringBuilder.append("-".repeat(car.getDistance()));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
