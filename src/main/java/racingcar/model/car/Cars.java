package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    private Cars() {

    }

    public static Cars create() {
        return new Cars();
    }

    public void add(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다.");
        }

        cars.add(car);
    }
}
