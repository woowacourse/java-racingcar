package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

public class CarStates {
    private static final String DELIMITER = "\n";

    private final List<CarState> carStates;

    private CarStates(List<CarState> carStates) {
        this.carStates = carStates;
    }

    public static CarStates valueOf(List<CarState> carStates) {
        return new CarStates(carStates);
    }

    @Override
    public String toString() {
        return String.join(
                DELIMITER,
                carStates.stream()
                        .map(CarState::toString)
                        .collect(Collectors.toList())
        );
    }
}
