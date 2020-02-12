package racingcar.domian;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

}
