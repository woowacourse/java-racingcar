package racing.domain;

import racing.domain.dto.WinnersDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validateWinners();
    }

    public WinnersDto getWinnersDto() {
        List<String> winnersName = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return new WinnersDto(winnersName);
    }

    private void validateWinners() {
        if (this.cars.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
