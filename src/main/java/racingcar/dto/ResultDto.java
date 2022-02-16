package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class ResultDto {
    private List<String> winners;

    public ResultDto(List<String> winners) {
        this.winners = winners;
    }

    public static ResultDto createResultDto(List<Car> cars) {
        return new ResultDto(cars.stream()
            .map(car -> car.getName())
            .collect(Collectors.toList()));
    }

    public List<String> getRacingWinner() {
        return winners;
    }
}
