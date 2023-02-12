package dto;

import domain.Car;
import vo.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Result {
    private final Map<String, Position> result;

    private Result(Map<String, Position> result) {
        this.result = result;
    }

    public static Result of(List<Car> cars) {
        HashMap<String, Position> resultHolder = new HashMap<>();
        for (Car car : cars) {
            resultHolder.put(car.getName(), car.getPosition());
        }
        return new Result(resultHolder);
    }

    public void forEach(BiConsumer<? super String, ? super Position> action) {
        result.forEach(action);
    }
}
