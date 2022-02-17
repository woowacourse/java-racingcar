package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarToCarDtoMapper {

	private CarToCarDtoMapper() {
	}

	public static List<CarDto> carsToCarDtos(List<Car> cars) {
		return cars.stream()
			.map(CarDto::new)
			.collect(Collectors.toList());
	}
}
