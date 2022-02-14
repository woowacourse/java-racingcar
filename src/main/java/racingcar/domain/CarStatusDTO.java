package racingcar.domain;

import java.util.Map;

public class CarStatusDTO {
	String carName;
	int position;

	public CarStatusDTO(String carName, int position) {
		this.carName = carName;
		this.position = position;
	}

	public String getCarName() {
		return carName;
	}

	public int getPosition() {
		return position;
	}
}
