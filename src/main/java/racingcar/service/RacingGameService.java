package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;
import racingcar.repository.CarRepository;

public class RacingGameService {
    private final CarRepository carRepository;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGameService(CarRepository carRepository, RandomNumberGenerator randomNumberGenerator) {
        this.carRepository = carRepository;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void proceedTurn() {
        List<Car> cars = carRepository.findAll();

        for (Car car : cars) {
            car.move(randomNumberGenerator.getRandomNumber());
        }
    }
}
