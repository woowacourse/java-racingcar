package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.numbergenerator.NumberGenerator;


public class NumberApplicatorToCar {
    private final CarRepository carRepository;
    private final NumberGenerator numberGenerator;
    private static final int MIN_NUMBER_TO_GO_FORWARD = 4;

    public NumberApplicatorToCar(CarRepository carRepository, NumberGenerator numberGenerator) {
        this.carRepository = carRepository;
        this.numberGenerator = numberGenerator;
    }

    public void apply() {
        List<Car> allCars = carRepository.getAllCars();
        allCars.forEach(this::applyNumberToCar);
    }

    private void applyNumberToCar(Car car) {
        int generatedNumber = numberGenerator.generate();
        if (MIN_NUMBER_TO_GO_FORWARD <= generatedNumber) {
            car.goForward();
        }
    }
}
