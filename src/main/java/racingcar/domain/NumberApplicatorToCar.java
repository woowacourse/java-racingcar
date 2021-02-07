package racingcar.domain;

import java.util.List;


public class NumberApplicatorToCar {
    private final CarRepository carRepository;
    private final NumberGenerator numberGenerator;
    private final int MIN_NUMBER_TO_GO_FORWARD = 4;

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
