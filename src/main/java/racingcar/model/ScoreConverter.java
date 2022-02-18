package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreConverter {
    public static Score of(Car car) {
        return new Score(car.getName(), car.getPosition());
    }

    public static List<Score> of(List<Car> cars) {
        return cars.stream()
                .map(ScoreConverter::of)
                .collect(Collectors.toUnmodifiableList());
    }
}
