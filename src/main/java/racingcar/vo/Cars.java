package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.numberGenerator.NumberGenerator;
import racingcar.numberGenerator.RandomNumberGenerator;
import racingcar.view.ErrorMessage;

public class Cars {

    private static final int NONE_DUPLICATION = 0;
    private static final String DEFAULT_RACE_ALL_RESULT = "자동차 경주 진행 전입니다.";

    private final List<Car> cars;
    private final String raceAllResult;

    public Cars(String[] names) {
        cars = new ArrayList<>();
        raceAllResult = DEFAULT_RACE_ALL_RESULT;
        createCarsWith(names);
    }

    private Cars(List<Car> cars, String raceAllResult) {
        this.cars = new ArrayList<>(cars);
        this.raceAllResult = raceAllResult;
    }

    private void createCarsWith(String[] names) {
        for (String name : names) {
            addCar(name);
        }
    }

    private void addCar(String name) {
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        validateDuplicateCarName(car);
        cars.add(car);
    }

    public Cars repeatRaceBy(Attempt attempt) {
        StringBuilder raceAllResultBuilder = new StringBuilder();
        List<Car> cars = new ArrayList<>(this.cars);
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        while (attempt.isLeft()) {
            cars = raceAll(cars, randomNumberGenerator);
            raceAllResultBuilder.append(getRaceResultWith(cars));
            attempt = attempt.decrease();
        }
        return new Cars(cars, raceAllResultBuilder.toString());
    }

    private List<Car> raceAll(List<Car> cars, NumberGenerator numberGenerator) {
        List<Car> afterRaceCars = new ArrayList<>();
        for (Car car : cars) {
            Car movedCar = car.move(numberGenerator.generate());
            afterRaceCars.add(movedCar);
        }
        return afterRaceCars;
    }

    private String getRaceResultWith(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString());
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public Winners judgeWinners() {
        Car maxPositionCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchElementException(ErrorMessage.CAR_NOT_FOUND.toString()));
        return new Winners(cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList()));
    }

    private void validateDuplicateCarName(Car car) {
        long countDuplication = cars.stream()
                .filter(each -> each.isSameName(car))
                .count();
        if (countDuplication != NONE_DUPLICATION) {
            throw new RuntimeException(ErrorMessage.CAR_NAME_DUPLICATE.toString());
        }
    }

    public boolean isSameSize(int size) {
        return cars.size() == size;
    }

    public String getRaceAllResult() {
        return raceAllResult;
    }
}
