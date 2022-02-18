package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreConverter {
    public static Score of(CarDto car) {
        return new Score(car.getName(), car.getPosition());
    }

    public static List<Score> of(List<CarDto> cars) {
        return cars.stream()
                .map(ScoreConverter::of)
                .collect(Collectors.toUnmodifiableList());
    }
}
