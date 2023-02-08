package racingcar.domain.carfactory;

import racingcar.domain.car.Car;
import racingcar.domain.carrepository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public CarRepository createCarRepository(List<String> carNames){
        return new CarRepository(makeCars(carNames));
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> createCar(carName))
                .collect(Collectors.toList());
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }
}
