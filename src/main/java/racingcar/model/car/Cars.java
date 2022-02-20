package racingcar.model.car;

import racingcar.service.CarDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

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

    public void create(List<String> names) {
        validateDuplication(names);
        for (String name: names) {
            cars.add(new Car(name));
        }
    }

    private void validateDuplication(List<String> names) {
        Set<String> checkDuplication = new HashSet<>(names);
        if (checkDuplication.size() != names.size()) {
            throw new RuntimeException("중복된 이름이 존재합니다.");
        }
    }
}
