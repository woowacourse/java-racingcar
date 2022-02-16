package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.CarDto;

public class Cars {
    private static final String ERROR_CAR_EMPTY = "자동차가 존재하지 않습니다.";
    public static final String ERROR_DUPLICATED_CAR_NAME_MESSAGE = "중복값을 입력할 수 없습니다.";
    public static final int CAR_NAME_MIN_LENGTH = 1;
    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE = 1 + "~" + 5 + " 글자 범위 내에서 입력하세요.";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(List<String> carNames) {
        //todo: 2. model 자체 검증 - List<String>
        validateCarNames(carNames);
        return new Cars(carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList()));
    }

    public static Cars from(List<Car> cars) {
        //todo: 3. model List<객체> -> List<String>으로 축소변환후 재활용
        //todo: 4. List<객체> 검증시.. 이미 car 만들 때 검증하고 온다 -> 중복검사만 해주면 된다..?
        validateCarNames(getCarNames(cars));
        return new Cars(cars);
    }

    private static void validateCarNames(List<String> carNames) {
        checkCarNamesDuplicated(carNames);
        for (String carName : carNames) {
            checkValidLengthOfCarName(carName);
        }
    }

    private static List<String> getCarNames(List<Car> cars) {
        return cars.stream().map(car -> car.toString()).collect(Collectors.toList());
    }

    private static void checkCarNamesDuplicated(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_CAR_NAME_MESSAGE);
        }
    }

    private static void checkValidLengthOfCarName(String carName) {
        int carNameLength = carName.length();
        if (!(CAR_NAME_MIN_LENGTH <= carNameLength && carNameLength <= CAR_NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE);
        }
    }

    public void driveAll(NumberGeneratePolicy numberGeneratePolicy) {
        cars.forEach(car -> car.drive(numberGeneratePolicy.generateNumber()));
    }

    public List<CarDto> getWinners() {
        final Car maxPositionCar = findMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(car -> CarDto.from(car))
                .collect(Collectors.toList());
    }

    public Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_CAR_EMPTY));
    }

    public List<CarDto> getCurrentCars() {
        return cars.stream()
                .map(car -> CarDto.from(car))
                .collect(Collectors.toList());
    }
}
