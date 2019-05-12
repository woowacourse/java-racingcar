package racingcar;

import java.util.*;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    Cars(List<String> carNames) {
        Car.instantiateCar(carNames, cars);
    }

    Cars(List<String> carNames, List<Integer> positions) {
        Car.instantiateCar(carNames, cars, positions);
    }

    public int getSize() {
        return cars.size();
    }

    public String getCarState(int index) {
        return cars.get(index).getCarState();
    }

    public void updateCarMovement(int index) {
        cars.get(index).moveCar(Car.randomNumberGenerator());
    }

    public int decideMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = car.findMax(max);
        }
        return max;
    }

    public List<String> decideWinners(int maxPosition) {
        List<String> winnersName = new ArrayList<>();
        for (Car car : cars) {
            car.findScoreSameAsMax(maxPosition, winnersName);
        }
        return winnersName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
