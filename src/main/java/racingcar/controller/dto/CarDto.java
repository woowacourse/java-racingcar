package racingcar.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import racingcar.domain.Car;
import racingcar.domain.vo.CarName;

public class CarDto {

	private final CarName name;
	private final int position;

	public CarDto(CarName name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name.get();
	}

	public int compareTo(final Function<CarDto, Integer> function, final CarDto other) {
		return function.apply(other);
	}

	public int compareNameTo(final CarDto other) {
		return compareTo((CarDto otherCar) -> this.name.get().compareTo(other.getName()), other);
	}

	public static List<CarDto> from(List<Car> cars) {
		List<CarDto> carDtos = new ArrayList<>();
		for (Car car : cars) {
			carDtos.add(car.toDto());
		}
		return carDtos;
	}

	@Override
	public String toString() {
		return name + " : " + "-".repeat(position);
	}
}
