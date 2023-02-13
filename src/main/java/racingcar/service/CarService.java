package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.Cars;

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
            Random random = new Random();
            int randomNumber = random.nextInt(Car.RANDOM_NUMBER_BOUNDARY);
            runForward(car, randomNumber);
            car.validateCurrentDistance(round);
        }
    }

    public void runForward(Car car, int randomNumber) {
        if (randomNumber >= Car.FORWARD_BOUNDARY) {
            car.increaseDistance();
        }
    }

    public List<String> findWinner() {
        int maxDistance = findMaxDistance();
        for (Car car : cars.getCars()) {
            compareDistance(car, maxDistance);
        }
        return winner;
    }

    private int findMaxDistance() {
        int maxDistance = -1;
        for (Car car : cars.getCars()) {
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
