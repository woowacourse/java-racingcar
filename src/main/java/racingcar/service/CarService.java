package racingcar.service;

import java.util.ArrayList;
import java.util.List;

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

		final int[] max = {0};
		cars.stream().forEach(car -> {
			if (car.getPosition() > max[0]) {
				max[0] = car.getPosition();
				winners.clear();
			}
			if (car.getPosition() >= max[0]) {
				winners.add(car.getName());
			}
		});
		return winners;
	}

	public String getPositionToString() {
		StringBuilder sb = new StringBuilder();
		cars.stream()
			.forEach((car) -> sb.append(car.toString()).append("\n"));
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
