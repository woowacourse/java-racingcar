package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultByRoundDto {

    private final List<CarInfoDto> resultByRound;

    private ResultByRoundDto(final List<CarInfoDto> resultByRound) {
        this.resultByRound = resultByRound;
    }

    public static ResultByRoundDto from(final List<Car> cars) {
        final List<CarInfoDto> carsInfo = cars.stream()
                .map(car -> new CarInfoDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());

        return new ResultByRoundDto(carsInfo);
    }

    public List<CarInfoDto> getResultByRound() {
        return resultByRound;
    }
}
