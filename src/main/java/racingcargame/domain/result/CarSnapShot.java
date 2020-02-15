package racingcargame.domain.result;

import racingcargame.domain.car.Car;
import racingcargame.utils.StringUtils;

public class CarSnapShot {

    private static final String CAR_POSITION_EXPRESSION = "-";
    private static final String CAR_STATUS_FORMAT = "%-" + Car.getCarNameLimit() + "s: %s";

    private final String name;
    private final int position;

    public CarSnapShot(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public boolean isSamePositionWith(int position) {
        return this.position == position;
    }

    public String getStatus() {
        return String.format(CAR_STATUS_FORMAT, name, StringUtils.multiply(CAR_POSITION_EXPRESSION, position));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
