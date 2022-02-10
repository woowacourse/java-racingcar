package racingCar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingCar.model.Car;
import racingCar.utlis.Convertor;
import racingCar.validator.NameValidator;

public class RacingCarService {

	private List<Car> cars = new ArrayList<>();
	private int count;

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
}
