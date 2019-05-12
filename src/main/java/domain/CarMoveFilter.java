package domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarMoveFilter {
    private final MoveStrategy moveStrategy;

    public CarMoveFilter(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public ArrayList<Car> adjust(ArrayList<Car> cars) {
        return new ArrayList<>(cars.stream().filter((car) -> moveStrategy.isMove()).collect(Collectors.toList()));
    }
}
