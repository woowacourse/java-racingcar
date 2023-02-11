package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.constants.CarConstant;
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
            cars.addCarInformation(car);
        }
    }

    public List<Car> getCarsStatus() {
        return cars.getCarInformation();
    }

    public void runRound(int round) {
        for (Car car : cars.getCarInformation()) {
            Random random = new Random();
            int randomNumber = random.nextInt(CarConstant.RANDOM_NUMBER_BOUNDARY.getNumber());
            runForward(car, randomNumber);
            car.validateCurrentDistance(round);
        }
    }

    public void runForward(Car car, int randomNumber) {
        if (randomNumber >= CarConstant.FORWARD_BOUNDARY.getNumber()) {
            car.increaseDistance();
        }
    }

    public List<String> findWinner() {
        int maxDistance = findMaxDistance();
        for (Car car : cars.getCarInformation()) {
            compareDistance(car, maxDistance);
        }
        return winner;
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
