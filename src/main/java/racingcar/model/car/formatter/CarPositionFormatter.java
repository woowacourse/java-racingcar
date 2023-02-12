package racingcar.model.car.formatter;

import racingcar.model.car.Car;

public class CarPositionFormatter {
    private static final String POSITION_FORMAT_SYMBOL = "-";
    private static final String POSITION_STATE_FORMAT = "%s : %s";

    public String format(Car car) {
        String positionFormat = POSITION_FORMAT_SYMBOL.repeat(car.getPosition());
        return String.format(POSITION_STATE_FORMAT, car.getCarName(), positionFormat);
    }
}
