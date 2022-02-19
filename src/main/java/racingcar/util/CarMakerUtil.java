package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.ErrorMessage;
import racingcar.vo.Car;
import racingcar.vo.CarName;

public class CarMakerUtil {

    private static final int NONE_DUPLICATION = 0;

    public static List<Car> createCarsWith(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            addCar(name, cars);
        }
        return cars;
    }

    private static void addCar(String name, List<Car> cars) {
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        validateDuplicateCarName(car, cars);
        cars.add(car);
    }

    private static void validateDuplicateCarName(Car car, List<Car> cars) {
        long countDuplication = cars.stream()
                .filter(each -> each.isSameName(car))
                .count();
        if (countDuplication != NONE_DUPLICATION) {
            throw new RuntimeException(ErrorMessage.CAR_NAME_DUPLICATE.getMessage());
        }
    }
}
