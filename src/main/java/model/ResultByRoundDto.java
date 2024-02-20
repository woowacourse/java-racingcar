package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultByRoundDto {

    private final List<CarDto> resultByRound;

    private ResultByRoundDto(final List<CarDto> resultByRound) {
        this.resultByRound = resultByRound;
    }

    public static ResultByRoundDto from(final List<Car> cars) {
        final List<CarDto> carsInfo = cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());

        return new ResultByRoundDto(carsInfo);
    }

    public List<CarDto> getResultByRound() {
        return Collections.unmodifiableList(this.resultByRound);
    }
}
