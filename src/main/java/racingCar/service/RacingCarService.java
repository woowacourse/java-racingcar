package racingCar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingCar.repository.RacingCars;
import racingCar.utlis.Convertor;
import racingCar.validator.NameValidator;

public class RacingCarService {

	RacingCars racingCars = new RacingCars();

	public void saveCars(String carsNames) throws Exception {
		List<String> carNameList = new ArrayList<>(Arrays.asList(Convertor.separateNamesByDelimiter(carsNames)));
		NameValidator.checkOneName(carNameList);
		NameValidator.checkDuplicatedName(carNameList);
		racingCars.save(carNameList);
	}
}
