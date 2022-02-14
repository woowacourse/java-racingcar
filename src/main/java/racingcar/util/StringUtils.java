package racingcar.util;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;

public class StringUtils {
    private static final String DISTANCE_MARK = "-";
    private static final String NEW_LINE = System.lineSeparator();

    public static String[] splitByDelimiter(String string, String delimiter) {
        return string.split(delimiter);
    }

    public static String[] stripStringArray(String[] array) {
        int length = array.length;
        String[] copyArr = new String[length];
        IntStream.range(0, length).forEach(i -> copyArr[i] = array[i].strip());
        return copyArr;
    }

    public static String getGaugeBar(int cnt) {
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
        String carPositionString = StringUtils.getGaugeBar(car.getPosition());
        return car.getName() + " : " + carPositionString;
    }

}
