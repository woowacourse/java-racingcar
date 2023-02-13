package racingcar.view.formatter.car;

import java.util.stream.Collectors;
import racingcar.model.car.Cars;

public class CarsPositionFormatter {
    private static final String LINE_BREAK = System.lineSeparator();

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
