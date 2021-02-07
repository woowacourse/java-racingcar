package racingcar.domain;

import java.util.List;
// TODO: ApplicatorNumbersToCar -> NumberApplicatorToCar
public class ApplicatorNumbersToCar {
    private final CarRepository carRepository;
    private final NumberGenerator numberGenerator;
    private final int MIN_NUMBER_TO_GO_FORWARD = 4;

    public ApplicatorNumbersToCar(CarRepository carRepository, NumberGenerator numberGenerator) {
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
