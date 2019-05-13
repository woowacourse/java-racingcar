package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceStatusDto {
    private final List<Car> cars;

    public RaceStatusDto(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
