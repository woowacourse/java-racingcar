package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String NO_NAME_ERROR = "반드시 자동차 이름을 입력하셔야 합니다.";
    private static final String COMMA = ",";

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String carNames) {
        List<Car> carList = new ArrayList<>();
        String[] carNamesArray = carNamesSplit(carNames);
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    private static String[] carNamesSplit(String carNames) {
        String[] carNamesArray = carNames.split(COMMA);
        if (carNamesArray.length == 0) {
            throw new IllegalArgumentException(NO_NAME_ERROR);
        }
        return carNamesArray;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(MoveValueStrategy moveValueStrategy) {
        for (Car car : cars) {
            car.move(moveValueStrategy);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
        return winners;
    }

    private int getMaxPosition() {
        int position = 0;
        for (Car car : cars) {
            position = car.findMaxPosition(position);
        }
        return position;
    }
}