package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import racingcar.dto.CarDto;
import racingcar.util.IntGenerator;

public class Cars {
    List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new LinkedList<>();
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public Cars(List<String> carNames, IntGenerator intGenerator) {
        this.cars = new LinkedList<>();
        carNames.forEach(carName -> cars.add(new Car(carName, intGenerator)));
    }

    public void requestMoveEachCar() {
        cars.forEach(Car::tryMove);
    }

    public List<CarDto> getStatuses() {
        List<CarDto> carDtos = new LinkedList<>();
        cars.forEach(car -> carDtos.add(car.getStatus()));
        return carDtos;
    }

}
