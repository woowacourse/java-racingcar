package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarToCarDtoMapper {

	private CarToCarDtoMapper() {
	}

	public static List<CarDto> ToCarDtos(List<Car> cars) {
		return cars.stream()
			.map(CarDto::new)
			.collect(Collectors.toList());
	}

	public static List<List<CarDto>> ToCarDtoGroups(List<List<Car>> carsGroup) {
		return carsGroup.stream()
			.map(CarToCarDtoMapper::ToCarDtos)
			.collect(Collectors.toList());
	}
}
