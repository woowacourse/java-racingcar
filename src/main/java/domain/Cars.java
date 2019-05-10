package domain;

import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private List<String> carNames;

    public Cars(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<Car> createCars() {
        Util.checkCarNameZeroSize(carNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            if (cars.contains(car)) {
                throw new IllegalArgumentException(Const.EX_NAME_DUPLE);
            }
            cars.add(car);
        }
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(carNames, cars.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames);
    }
}
