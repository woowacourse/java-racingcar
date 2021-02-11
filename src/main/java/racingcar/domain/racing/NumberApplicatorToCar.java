package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.numbergenerator.NumberGenerator;


public class NumberApplicatorToCar {
    private final Cars carRepository;
    private final NumberGenerator numberGenerator;

    public NumberApplicatorToCar(Cars carRepository, NumberGenerator numberGenerator) {
        this.carRepository = carRepository;
        this.numberGenerator = numberGenerator;
    }

    public void apply() {
        List<Car> allCars = carRepository.getAllCars();
        allCars.forEach(this::applyNumberToCar);
    }

    private void applyNumberToCar(Car car) {
        int generatedNumber = numberGenerator.generate();
        car.goForwardDependsOnNumber(generatedNumber);
    }
}
