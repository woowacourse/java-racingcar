package racingcargame.domain;

import racingcargame.util.RandomFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class RacingCars {
    private static final String DELIMITER = ",";
    private static final String ONE_CAR_ERROR_MESSAGE = "하나의 자동차만 입력되었습니다.";
    private static final String NO_CAR_ERROR_MESSAGE = "공백이 입력되었습니다.";
    private static final String NAME_DUPLICATE_ERROR_MESSAGE = "자동차의 이름이 중복되었습니다.";

    private final List<Car> cars = new ArrayList<>();

    private RacingCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public static RacingCars createRacingCars(String inputCarNames, Engine engine) {
        String[] splicedInputCarNames = inputCarNames.split(DELIMITER);
        trimName(splicedInputCarNames);
        validCarAmount(splicedInputCarNames);
        validCarNameDuplicate(splicedInputCarNames);
        List<Car> cars = new ArrayList<>();
        for (String inputCarName : splicedInputCarNames) {
            cars.add(new Car(inputCarName, 0, engine));
        }
        return new RacingCars(cars);
    }

    public void move() {
        cars.forEach(car -> car.go(RandomFactory.getRandom()));
    }

    private static void validCarNameDuplicate(String[] names) {
        Set<String> carNames = new HashSet<>();
        for (String name : names) {
            if (carNames.contains(name)) {
                System.out.println(NAME_DUPLICATE_ERROR_MESSAGE);
                throw new IllegalStateException(NAME_DUPLICATE_ERROR_MESSAGE);
            }
            carNames.add(name);
        }
        carNames.clear();
    }

    private static void trimName(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
    }

    private static void validCarAmount(String[] splicedInputCarNames) {
        if (splicedInputCarNames.length == 1) {
            if (splicedInputCarNames[0].isEmpty()) {
                System.out.println(NO_CAR_ERROR_MESSAGE);
                throw new IllegalStateException(NO_CAR_ERROR_MESSAGE);
            }
            System.out.println(ONE_CAR_ERROR_MESSAGE);
            throw new IllegalStateException(ONE_CAR_ERROR_MESSAGE);
        }
    }

    public List<Car> getUnmodifiableCars() {
        return Collections.unmodifiableList(cars);
    }
}
