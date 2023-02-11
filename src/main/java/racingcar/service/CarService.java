package racingcar.service;

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
		int maxPosition = cars.stream()
			.mapToInt(Car::getPosition)
			.max().orElse(0);

		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
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
