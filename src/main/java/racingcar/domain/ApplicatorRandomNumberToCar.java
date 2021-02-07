package racingcar.domain;

import java.util.List;

public class ApplicatorRandomNumberToCar {
    private final CarRepository carRepository;
    private final RandomNumberGenerator randomNumberGenerator;
    private final int MIN_NUMBER_TO_GO_FORWARD = 4;

    public ApplicatorRandomNumberToCar(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void apply() {
        List<Car> allCars = carRepository.getAllCars();
        allCars.forEach(this::applyRandomNumber);
    }

    private void applyRandomNumber(Car car) {
        int randomNumber = randomNumberGenerator.generateFromZeroToNine();
        if (randomNumber >= MIN_NUMBER_TO_GO_FORWARD) {
            car.goForward();
        }
    }
}
