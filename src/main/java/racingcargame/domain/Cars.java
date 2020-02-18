package racingcargame.domain;

import racingcargame.exception.CarsNameInputException;
import racingcargame.exception.CarsNameInputExceptionType;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    public static final String CAR_NAMES_DELIMITER = ",";
    public static final String BLANK = "";

    private final List<Car> readOnlyCars;

    public Cars(List<Car> cars) {
        this.readOnlyCars = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public static Cars create(String inputCarNames) {
        checkCarAmount(inputCarNames);
        String[] separatedCarNames = inputCarNames.split(CAR_NAMES_DELIMITER);
        checkDuplicatedNames(separatedCarNames);
        List<Car> cars = createCars(separatedCarNames);
        return new Cars(cars);
    }

    private static void checkCarAmount(String inputCarNames) {
        checkNoCars(inputCarNames);
        checkOnlyOneCar(inputCarNames);
    }

    private static void checkNoCars(String inputCarNames) {
        String[] separatedCarNames = inputCarNames.split(CAR_NAMES_DELIMITER);
        if (BLANK.equals(inputCarNames) || separatedCarNames.length == 0) {
            throw new CarsNameInputException(CarsNameInputExceptionType.NO_CAR, "※매개변수가 blank거나 구분자만 입력됨");
        }
    }

    private static void checkOnlyOneCar(String inputCarNames) {
        if (!inputCarNames.contains(CAR_NAMES_DELIMITER)) {
            throw new CarsNameInputException(CarsNameInputExceptionType.ONLY_ONE_CAR, "※구분자가 없는 입력값이 들어옴");
        }
    }

    private static void checkDuplicatedNames(String[] separatedCarNames) {
        Set<String> carNames = Arrays.stream(separatedCarNames)
                .map(String::trim)
                .collect(Collectors.toSet());
        if (carNames.size() != separatedCarNames.length) {
            throw new CarsNameInputException(CarsNameInputExceptionType.DUPLICATED_NAMES, "※중복되는 자동차 이름이 존재");
        }
    }

    private static List<Car> createCars(String[] separatedCarNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : separatedCarNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void move() {
        readOnlyCars.forEach(car -> car.go(Engine.create()));
    }

    public List<Car> extractWinners() {
        List<Car> cars = new ArrayList<>(readOnlyCars);
        Collections.sort(cars);
        Car topPositionCar = cars.get(cars.size() - 1);
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePositionWith(topPositionCar))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winners);
    }

    public List<Car> getDeepCopiedCars() {
        List<Car> deepCopiedCars = new ArrayList<>();
        for (Car car : readOnlyCars) {
            Car cloneCar = car.newClone();
            deepCopiedCars.add(cloneCar);
        }
        return deepCopiedCars;
    }
}
