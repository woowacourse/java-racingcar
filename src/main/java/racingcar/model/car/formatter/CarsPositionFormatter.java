package racingcar.model.car.formatter;

import java.util.stream.Collectors;
import racingcar.model.car.Cars;

public class CarsPositionFormatter {
    private static final String LINE_BREAK = "\n";

    private final CarPositionFormatter carFormatter;

    public CarsPositionFormatter(CarPositionFormatter carFormatter) {
        this.carFormatter = carFormatter;
    }

    public String formatCarsPosition(Cars cars) {
        return cars.getCars().stream()
                .map(carFormatter::formatCarPosition)
                .collect(Collectors.joining(LINE_BREAK)) + LINE_BREAK;
    }
}
