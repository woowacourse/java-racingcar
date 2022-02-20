package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarDtos {
	private final List<CarDto> carDtos;

	public CarDtos(List<Car> cars) {
		this.carDtos = ToCarDtos(cars);
	}
	public static List<CarDto> ToCarDtos(List<Car> cars) {
		return cars.stream()
			.map(CarDto::new)
			.collect(Collectors.toList());
	}

	public List<CarDto> getCarDtos() {
		return carDtos;
	}
}
