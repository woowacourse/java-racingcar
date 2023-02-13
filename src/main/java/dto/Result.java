package dto;

import domain.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Result {
    private final Map<String, Long> result;

    private Result(Map<String, Long> result) {
        this.result = result;
    }

    public static Result of(List<Car> cars) {
        HashMap<String, Long> resultHolder = new HashMap<>();
        for (Car car : cars) {
            resultHolder.put(car.getName(), car.getPosition());
        }
        return new Result(resultHolder);
    }

    public void forEach(BiConsumer<? super String, ? super Long> action) {
        result.forEach(action);
    }
}
