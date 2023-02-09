package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {

	private NumberGenerator numberGenerator;
	List<Car> cars = CarRepository.getCars();

	public CarService(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public void moveCars() {
		cars.stream().forEach(car -> car.move(numberGenerator.getNumber()));
	}

	public List<String> getWinners() {
		List<String> winners = new ArrayList<>();

		final int[] maxPos = {0};
		cars.stream()
			.forEach(car -> maxPos[0] = car.getPosition() > maxPos[0] ? car.getPosition() : maxPos[0]);

		return cars.stream()
			.filter(car -> car.getPosition() == maxPos[0])
			.map(car -> car.getName())
			.collect(Collectors.toList());
	}

	public String getPositionToString() {
		StringBuilder sb = new StringBuilder();
		cars.stream()
			.forEach((car) -> sb.append(car.toString()).append("\n"));
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
