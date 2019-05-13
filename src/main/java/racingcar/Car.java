package racingcar;

import java.util.*;

public class Car {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int STOP_OR_GO = 4;
    private static final int RANOM_GENERATING_NUMBER = 10;

    private final String name;
    private int position = 0;

    Car(String name) {
        checkConditionsForCar(name);
        this.name = name;
    }

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    private static void checkConditionsForCar(String carName) {
        if (isWhiteSpaceOnly(carName)||  isOverLimit(carName)) {
            throw new IllegalArgumentException();
        }
    }

    /*
    public static void instantiateCar(List<String> carNames, List<Car> cars) {
        try {
            isDuplicate(carNames);
            addCarToCars(carNames, cars);
        } catch (Exception e) {
            CarGameLauncher.doCarGame();
        }
    }

    public static void instantiateCar(List<String> carNames, List<Car> cars, List<Integer> positions) {
        try {
            isDuplicate(carNames);
            addCarToCars(carNames, cars, positions);
        } catch (Exception e) {
            CarGameLauncher.doCarGame();
        }
    }

    public static void addCarToCars(List<String> carNames, List<Car> cars) {
        for (int i = 0, n = carNames.size(); i < n; i++) {
            cars.add(new Car(carNames.get(i)));
        }
    }

    public static void addCarToCars(List<String> carNames, List<Car> cars, List<Integer> positions) {
        for (int i = 0, n = carNames.size(); i < n; i++) {
            cars.add(new Car(carNames.get(i), positions.get(i)));
        }
    }
     */

    public static boolean isWhiteSpaceOnly(String name) {
        return name.isEmpty();
    }

    public static boolean isOverLimit(String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }

    public Car moveCar(int randomNumber) {
        if (randomNumber >= STOP_OR_GO) {
            position++;
        }
        return this;
    }

    public static int randomNumberGenerator() {
    return (int) (Math.random() * RANOM_GENERATING_NUMBER);
    }

    public int findMax(int max) {
        if (position > max) {
            max = position;
        }
        return max;
    }

    public void findScoreSameAsMax(int maxPosition, List<String> winners) {
        if (maxPosition == this.position) {
            winners.add(this.name);
        }
    }

    public String getCarState() {
        String carState = this.name + " : ";
        for (int i = 0; i < this.position; i++) {
            carState += "-";
        }
        return carState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
