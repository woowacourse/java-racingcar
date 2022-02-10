package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
	private static final String NEW_LINE = System.lineSeparator();

	private final List<Car> cars = new ArrayList<>();

	public Cars(String[] carNames) {
		if (validateDuplicatedName(carNames)) {
			throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다");
		}
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	private boolean validateDuplicatedName(String[] carNames) {
		long distinctSize = Arrays.stream(carNames)
			.distinct().count();

		return distinctSize != carNames.length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car.toString())
				.append(NEW_LINE);
		}
		return sb.toString();
	}
}
