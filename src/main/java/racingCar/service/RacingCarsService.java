package racingCar.service;

import static racingCar.view.Output.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingCar.model.Car;
import racingCar.utlis.Convertor;
import racingCar.validator.NameValidator;
import racingCar.view.Output;

public class RacingCarsService {

	public List<Car> cars = new ArrayList<>();
	private int count;

	public void initiateCars(String nameString) throws Exception {
		List<String> carNameList = new ArrayList<>(Arrays.asList(Convertor.separate(nameString)));
		NameValidator.validateNameList(carNameList);
		save(carNameList);
	}

	public void save(List<String> carNameList) throws Exception {
		for (String name : carNameList) {
			cars.add(new Car(name));
		}
	}

	public void saveCount(int count) {
		this.count = count;
	}

	public void runGame() {
		printResult();
		for (int i = 0; i < count; i++) {
			carsGo();
			Output.printRoundResult(cars);
		}
	}

	public void carsGo() {
		for (Car car : cars) {
			car.go();
		}
	}

	public int findMaxPosition() {
		int max = 0;
		for (Car car : cars) {
			if (car.getPosition() >= max) {
				max = car.getPosition();
			}
		}
		return max;
	}

	public List<String> findWinner() {
		int max = findMaxPosition();
		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.isWinner(max)) {
				winners.add(car.getName());
			}
		}
		return winners;
	}
}