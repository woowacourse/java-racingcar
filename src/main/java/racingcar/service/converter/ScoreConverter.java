package racingcar.service.converter;

import racingcar.model.score.Score;
import racingcar.service.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreConverter {
    private static Score of(CarDto car) {
        return new Score(car.getName(), car.getPosition());
    }

    public static List<Score> of(List<CarDto> cars) {
        return cars.stream()
                .map(ScoreConverter::of)
                .collect(Collectors.toUnmodifiableList());
    }
}
