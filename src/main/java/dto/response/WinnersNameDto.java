package dto.response;

import domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnersNameDto {
    private final List<String> winnersNames;

    public static WinnersNameDto of(List<Car> winningCars) {
        return winningCars.stream()
                .map(Car::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinnersNameDto::new));
    }

    private WinnersNameDto(List<String> winnersNames) {
        this.winnersNames = winnersNames;
    }

    public List<String> getWinnersNames() {
        return Collections.unmodifiableList(winnersNames);
    }
}
