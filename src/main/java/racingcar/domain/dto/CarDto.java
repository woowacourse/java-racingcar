package racingcar.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarDto {
    private final String name;
    private final int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto of(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public static List<CarDto> of(List<Car> cars) {
        return cars.stream()
                .map(CarDto::of)
                .collect(Collectors.toList());
    }

    public static List<CarDto> of(Cars cars) {
        return of(cars.getCars());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
