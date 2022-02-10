package racingcar.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Predicate;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;
import racingcar.repository.CarRepository;

public class RacingGameService {

    private final CarRepository carRepository;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGameService(CarRepository carRepository,
        RandomNumberGenerator randomNumberGenerator) {
        this.carRepository = carRepository;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void proceedTurn() {
        moveCars(findAllCars());
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomNumberGenerator.getRandomNumber());
        }
    }

    private List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getWinners() {
        return getWinners(findAllCars(), getMostFarPosition(findAllCars()));
    }

    private int getMostFarPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().getAsInt();
    }

    private List<Car> getWinners(List<Car> cars, int mostFar) {
        return cars.stream().filter(isSamePosition(mostFar)).collect(toList());
    }

    private Predicate<Car> isSamePosition(int mostFar) {
        return c -> c.getPosition() == mostFar;
    }
}
