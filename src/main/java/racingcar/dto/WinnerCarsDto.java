package racingcar.dto;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCarsDto {
    List<String> winnerCarNames;

    public WinnerCarsDto(List<String> winnerCarNames) {
        this.winnerCarNames = winnerCarNames;
    }

    public static WinnerCarsDto from(List<Car> winnerCars) {
        List<String> winnerCarNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return new WinnerCarsDto(winnerCarNames);
    }

    public List<String> getWinnerCarNames() {
        return winnerCarNames;
    }
}
