package racing.controller;

import racing.model.Car;
import racing.model.Winner;
import racing.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {
    private final static String MSG_DUPLICATE_CAR_NAME = "중복된 차량 이름이 있습니다.";
    private final static String MSG_COUNT_MUST_POSITIVE = "게임횟수는 0보다 커야합니다.";
    private final static int RANDOM_NUMBER_RANGE= 10;
    private final static int POSITIVE_CONDITION = 1;
    private final static int POSITION_INIT = 0;

    private final List<Car> cars;
    private final int count;

    public Racing(String[] carNames, int count) {
        List<Car> bindingCar = bindCars(carNames);
        if (hasDuplicateCarName(bindingCar)) {
            throw new IllegalArgumentException(MSG_DUPLICATE_CAR_NAME);
        }
        if (count < POSITIVE_CONDITION) {
            throw new IllegalArgumentException(MSG_COUNT_MUST_POSITIVE);
        }
        this.cars = bindingCar;
        this.count = count;
    }

    private List<Car> bindCars(String[] carNames){
        List<Car> bindingCars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            bindingCars.add(new Car(carNames[i],POSITION_INIT));
        }
        return bindingCars;
    }

    private boolean hasDuplicateCarName(List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return cars.size() != carNames.size();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_RANGE);
    }

    public Winner getWinners() {
        return new Winner(cars);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
