package racingCar.service;

import static racingCar.view.Output.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingCar.model.Car;
import racingCar.utlis.Convertor;
import racingCar.validator.NameValidator;
import racingCar.view.Output;

public class RacingCarService {

	List<Car> cars = new ArrayList<>();
	private int count;

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

	public void saveCars(String carsNames) throws Exception {
		List<String> carNameList = new ArrayList<>(Arrays.asList(Convertor.separateNamesByDelimiter(carsNames)));
		NameValidator.checkOneName(carNameList);
		NameValidator.checkDuplicatedName(carNameList);
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

	public int findMaxPosition() {
		int max = 0;
		for (Car car : cars) {
			if (car.getPosition() >= max) {
				max = car.getPosition();
			}
		}
		return max;
	}

	
}