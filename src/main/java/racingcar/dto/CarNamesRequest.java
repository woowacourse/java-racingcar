package racingcar.dto;

import java.util.List;

public class CarNamesRequest {
	private final List<String> carNames;

	public static CarNamesRequest from(final List<String> carNames) {
		return new CarNamesRequest(carNames);
	}

	private CarNamesRequest(final List<String> carNames) {
		this.carNames = carNames;
	}

	public List<String> getCarNames() {
		return carNames;
	}
}
