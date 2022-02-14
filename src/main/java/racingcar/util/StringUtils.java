package racingcar.util;

import java.util.List;
import racingcar.model.Car;

public class StringUtils {
    private static final String DISTANCE_MARK = "-";
    private static final String NEW_LINE = System.lineSeparator();

    public static String convertNumberToString(int cnt) {
        return DISTANCE_MARK.repeat(Math.max(0, cnt));
    }

    public static String generateCarStatus(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(getCarStatus(car))
                    .append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    private static String getCarStatus(Car car) {
        String carPositionString = StringUtils.convertNumberToString(car.getPosition());
        return car.getName() + " : " + carPositionString;
    }

}
