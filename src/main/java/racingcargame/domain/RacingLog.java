package racingcargame.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcargame.domain.car.Car;
import racingcargame.domain.car.CarDto;

public class RacingLog {
	private List<CarDto> racingLog;

	public RacingLog(List<Car> cars) {
		Objects.requireNonNull(cars);
		this.racingLog = createCarDtos(cars);
	}

	private List<CarDto> createCarDtos(List<Car> cars) {
		return cars.stream().map(Car::convertToCarDto).collect(Collectors.toList());
	}

	public List<String> getWinners() {
		int maxPosition = calculateMaxPosition();

		return racingLog.stream()
			.filter(carDto -> carDto.isPositionOf(maxPosition))
			.map(CarDto::getName)
			.collect(Collectors.toList());
	}

	private int calculateMaxPosition() {
		return racingLog.stream().max(CarDto::compareTo).get().getPosition();
	}

	public List<CarDto> getRacingLog() {
		return racingLog;
	}
}
