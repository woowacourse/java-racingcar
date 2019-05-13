package domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarMoveFilter {
    private final MoveStrategy moveStrategy;

    public CarMoveFilter(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public List<Car> adjust(List<Car> cars) {
        return cars.stream().filter((car) -> moveStrategy.isMove()).collect(Collectors.toList());
    }
}
