package racingcar.domain;

import java.util.List;

public class MidtermResult {
    private List<Car> cars;

    public MidtermResult(List<Car> cars) {
        this.cars = cars;
    }

    public int getPositionByName(String name) {
        return findCarByName(name).getPosition();
    }

    private Car findCarByName(String name) {
        return cars.stream().filter(c -> c.getName().equals(name)).findFirst().get();
    }
}
