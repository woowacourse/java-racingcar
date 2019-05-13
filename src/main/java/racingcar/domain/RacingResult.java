package racingcar.domain;

import java.util.List;

public class RacingResult {
	private StringBuilder stringBuilder = new StringBuilder();

	public void saveCarPosition(List<Car> cars) {
		cars.forEach(car -> printCarPosition(car));
		stringBuilder.append("\n");
	}

	private void printCarPosition(Car car) {
		stringBuilder.append(car.toString() + " : ");
		for (int i = 0; i < car.getPosition(); ++i) {
			stringBuilder.append("-");
		}
		stringBuilder.append("\n");
	}

	@Override
	public String toString() {
		return stringBuilder.toString();
	}
}
