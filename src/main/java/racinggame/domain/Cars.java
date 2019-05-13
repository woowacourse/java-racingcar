package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = initializeCars(carNames);
    }

    private List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void moveBy(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generateNumber());
        }
    }

    public TrialHistory makeTrialHistory() {
        return new TrialHistory(cars);
    }

    public boolean equals(List<Car> cars) {
        return this.cars.equals(cars);
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
