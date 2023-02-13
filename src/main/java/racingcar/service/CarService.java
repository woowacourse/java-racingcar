package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Position;

public class CarService {
    private Cars cars;
    private final List<String> winner = new ArrayList<>();

    public void initializeCars() {
        cars = new Cars(new ArrayList<Car>());
    }

    public void makeCar(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.addCar(car);
        }
    }

    public void validateNegativeCount(int tryCount) {
        int minTryCount = Car.MIN_TRY_COUNT;
        if (tryCount <= minTryCount) {
            throw new IllegalArgumentException(String.format("[ERROR] 시도할 횟수는 %d보다 큰 숫자여야 합니다.", minTryCount));
        }
    }

    public List<Car> getCarsStatus() {
        return cars.getCars();
    }

    public void runRound(int round) {
        for (Car car : cars.getCars()) {
            Position position = car.getPosition();
            runForward(car, makeRandomNumber());
            position.validateCurrentPosition(position.getPosition(), round);
        }
    }

    public void runForward(Car car, int randomNumber) {
        if (randomNumber >= Car.FORWARD_BOUNDARY) {
            car.movePosition();
        }
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(Car.RANDOM_NUMBER_BOUNDARY);
    }

    public List<String> findWinner() {
        int maxPosition = findMaxPosition();
        for (Car car : cars.getCars()) {
            comparePosition(car, maxPosition);
        }
        return winner;
    }

    private int findMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars.getCars()) {
            Position position = car.getPosition();
            maxPosition = Math.max(position.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    private void comparePosition(Car car, int maxPosition) {
        Position position = car.getPosition();
        if (maxPosition == position.getPosition()) {
            winner.add(car.getName());
        }
    }
}
