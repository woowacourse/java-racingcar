package racingcar.util;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.lang.reflect.Field;
import java.util.List;

public class WinnerCarsHelper {

    public static Cars withWinnerCars(final List<Car> cars) {
        try {
            Cars result = new Cars(List.of("쓰레기값1", "쓰레기값2"));
            Field privateCarsField = result.getClass().getDeclaredField("cars");
            privateCarsField.setAccessible(true);
            privateCarsField.set(result, cars);

            return result;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Reflection Error");
        }
    }
}
