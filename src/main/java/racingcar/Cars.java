package racingcar;

import java.util.Collections;
import java.util.List;

public class Cars {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";
    private static final String NOT_FOUND_CAR_NAME_ERROR = "[ERROR] 해당하는 차 이름은 존재하지 않습니다.";

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        validateDuplicatedCarName(carList);
        cars = carList;
    }

    public int getNumberOfCar() {
        return cars.size();
    }

    private void validateDuplicatedCarName(List<Car> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

//    public Car getCarByName(String carName) {
//        return cars.stream()
//                .filter(car -> car.getName().equals(carName))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_CAR_NAME_ERROR));
//    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
