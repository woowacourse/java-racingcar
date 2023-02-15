package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarStatusDto;
import racingcar.util.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class CarsService {

    public Cars createCars(final String carNames, final NumberGenerator numberGenerator) {
        return Cars.create(carNames, numberGenerator);
    }

    public List<CarStatusDto> getCarStatus(final Cars carsInfo) {
        List<Car> cars = carsInfo.getCars();

        return cars.stream()
                .map(car -> CarStatusDto.create(car.getName(), car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }
}
