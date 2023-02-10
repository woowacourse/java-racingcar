package racingcar.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class RoundResultResponse {
	private final List<CarDto> roundResult;

	public static RoundResultResponse from(final Set<Car> cars) {
		return new RoundResultResponse(cars);
	}

	private RoundResultResponse(final Set<Car> cars) {
		roundResult = cars.stream()
			.map(CarDto::from)
			.collect(Collectors.toUnmodifiableList());
	}

	public List<CarDto> getRoundResult() {
		return roundResult;
	}
}
