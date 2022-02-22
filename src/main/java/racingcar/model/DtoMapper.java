package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.controller.GameResult;

public class DtoMapper {

	private DtoMapper() {
	}

	public static List<CarDto> ToCarDtos(List<Car> cars) {
		return cars.stream()
			.map(CarDto::new)
			.collect(Collectors.toList());
	}

	public static List<GameResult> ToGameResults(List<List<Car>> carsGroup) {
		return carsGroup.stream()
			.map(cars -> new GameResult(ToCarDtos(cars)))
			.collect(Collectors.toList());
	}
}
