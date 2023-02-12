package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.constants.CarConstant;
import racingcar.constants.InputConstant;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class CarService {
    private Cars cars = new Cars(new ArrayList<Car>());
    private int tryCount;
    private List<String> winner = new ArrayList<>();

    public void validateNameInput(String carNameInput) {
        cars = new Cars(new ArrayList<Car>());
        List<String> carNames = splitCarNames(carNameInput);
        makeCar(carNames);
    }

    public void validateCountInput(int tryCountInput) {
        tryCount = tryCountInput;
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

    public void runService() {
        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            runRound();
            System.out.println("");
        }
    }

    private void runRound() {
        for (Car car : cars.getCarInformation()) {
            Random random = new Random();
            int randomNumber = random.nextInt(10);
            runForward(car, randomNumber);
            OutputView.printRoundResult(car.getName(), car.getDistance());
        }
    }

    public void runForward(Car car, int randomNumber) {
        if (randomNumber >= CarConstant.MOVE_CRITERIA.getNumber()) {
            car.increaseDistance();
        }
    }

    public void finishService() {
        for (Car car : cars.getCarInformation()) {
            OutputView.printRoundResult(car.getName(), car.getDistance());
        }
        findWinner();
        OutputView.printWinners(winner);
    }

    private void findWinner() {
        int maxDistance = findMaxDistance();
        for (Car car : cars.getCarInformation()) {
            compareDistance(car, maxDistance);
        }
    }

    private int findMaxDistance() {
        int maxDistance = -1;
        for (Car car : cars.getCarInformation()) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    private void compareDistance(Car car, int maxDistance) {
        if (maxDistance == car.getDistance()) {
            winner.add(car.getName());
        }
    }
}
