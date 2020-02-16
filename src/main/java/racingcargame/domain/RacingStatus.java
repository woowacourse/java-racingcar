package racingcargame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcargame.domain.car.Car;
import racingcargame.domain.car.CarDto;

public class RacingStatus {
	private List<CarDto> racingStatus;

	RacingStatus(List<Car> cars) {
		this.racingStatus = createCarDtos(cars);
	}

	private List<CarDto> createCarDtos(List<Car> cars) {
		return cars.stream().map(Car::convertToCarDto).collect(Collectors.toList());
	}

	List<String> getWinners() {
		int maxPosition = calculateMaxPosition();

		return racingStatus.stream()
			.filter(carDto -> carDto.isPositionOf(maxPosition))
			.map(CarDto::getName)
			.collect(Collectors.toList());
	}

	private int calculateMaxPosition() {
		Collections.sort(racingStatus);
		return racingStatus.get(0).getPosition();
	}

	public List<CarDto> getRacingStatus() {
		return racingStatus;
	}
}
