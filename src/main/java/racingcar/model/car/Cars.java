package racingcar.model.car;

import racingcar.service.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void save(Car car) {
        cars.add(car);
    }

    public void move(List<Integer> numbers) {
        IntStream.range(0, numbers.size())
                .forEach(i -> cars.get(i).move(numbers.get(i)));
    }

    public int getSize() {
        return cars.size();
    }

    public List<CarDto> getCarDtos() {
        return carsToCarDtos(this.cars);
    }

    private List<CarDto> carsToCarDtos(List<Car> cars) {
        return cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }
}
