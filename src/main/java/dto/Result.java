package dto;

import domain.Car;
import vo.Name;
import vo.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Result {
    private final Map<Name, Position> result;

    private Result(Map<Name, Position> result) {
        this.result = result;
    }

    public static Result of(List<Car> cars) {
        HashMap<Name, Position> resultHolder = new HashMap<>();
        for (Car car : cars) {
            resultHolder.put(car.getName(), car.getPosition());
        }
        return new Result(resultHolder);
    }

    public void forEach(BiConsumer<? super Name, ? super Position> action) {
        result.forEach(action);
    }
}
