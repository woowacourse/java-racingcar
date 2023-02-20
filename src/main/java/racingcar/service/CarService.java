package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarService {
    private static final int RANDOM_NUM_MAX_VALUE = 10;
    private static final int MOVE_CRITERIA = 4;
    private static final int TRY_COUNT_MIN = 0;
    private Cars cars = new Cars(new ArrayList<>());

    public void makeCars(List<String> carNames) {
        cars = new Cars(new ArrayList<>());
        makeCar(carNames);
    }

    public void validateCountInput(int tryCount) {
        if (tryCount <= TRY_COUNT_MIN) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 0보다 큰 숫자여야 합니다.");
        }
    }

    private void makeCar(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.addCarInformation(car);
        }
    }

    public Map<String, Integer> runRound() {
        Map<String, Integer> roundResult = new LinkedHashMap<>();
        Random random = new Random();
        for (Car car : cars.getCarInformation()) {
            int randomNumber = random.nextInt(RANDOM_NUM_MAX_VALUE);
            runForward(car, randomNumber);
            roundResult.put(car.getName(), car.getDistance());
        }
        return roundResult;
    }

    public void runForward(Car car, int engine) {
        if (engine >= MOVE_CRITERIA) {
            car.increaseDistance();
        }
    }

    public Map<String, Integer> finishRound() {
        Map<String, Integer> roundResult = new LinkedHashMap<>();
        for (Car car : cars.getCarInformation()) {
            roundResult.put(car.getName(), car.getDistance());
        }
        return roundResult;
    }

    public List<String> finishGame() {
        return cars.findWinner(cars.findMaxDistance());
    }
}
