package dto.response;

import domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnersNameDto {
    private final List<String> winnersNames;

    public static WinnersNameDto of(List<Car> winningCars) {
        List<String> winnersName = winningCars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        return new WinnersNameDto(winnersName);
    }

    private WinnersNameDto(List<String> winnersNames) {
        this.winnersNames = winnersNames;
    }
    public List<String> getWinnersNames() {
        return Collections.unmodifiableList(winnersNames);
    }
}
