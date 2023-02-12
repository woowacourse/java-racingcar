package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import racingcar.constants.CarConstant;
import racingcar.constants.InputConstant;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarService {
    private Cars cars = new Cars(new ArrayList<Car>());
    public final int RANDOM_NUM_MAX_VALUE = 10;

    public void validateNameInput(String carNameInput) {
        cars = new Cars(new ArrayList<Car>());
        List<String> carNames = splitCarNames(carNameInput);
        makeCar(carNames);
    }

    public void validateCountInput(int tryCount) {
        if (tryCount <= CarConstant.TRY_COUNT_MIN.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 0보다 큰 숫자여야 합니다.");
        }
    }

    private void makeCar(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName, CarConstant.DISTANCE_DEFAULT.getNumber());
            cars.addCarInformation(car);
        }
    }

    public List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(InputConstant.CAR_NAME_SPLIT_DELIMITER.getMessage()));
    }

    public LinkedHashMap<String, Integer> runRound() {
        LinkedHashMap<String, Integer> roundResult = new LinkedHashMap<String, Integer>();
        for (Car car : cars.getCarInformation()) {
            Random random = new Random();
            int randomNumber = random.nextInt(RANDOM_NUM_MAX_VALUE);
            runForward(car, randomNumber);
            roundResult.put(car.getName(), car.getDistance());
        }
        return roundResult;
    }

    public void runForward(Car car, int engine) {
        if (engine >= CarConstant.MOVE_CRITERIA.getNumber()) {
            car.increaseDistance();
        }
    }

    public LinkedHashMap<String, Integer> finishRound() {
        LinkedHashMap<String, Integer> roundResult = new LinkedHashMap<>();
        for (Car car : cars.getCarInformation()) {
            roundResult.put(car.getName(), car.getDistance());
        }
        return roundResult;

    }

    public List<String> finishGame() {
        List<String> winner = cars.findWinner(cars.findMaxDistance());
        return winner;
    }
}
