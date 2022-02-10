package racingCar.model;

import racingCar.validator.NameValidator;

public class Car {

	private String name;
	private int position = 0;

	public Car(String name) throws Exception {
		NameValidator.checkSpace(name);
		NameValidator.checkNameSize(name);
		NameValidator.checkSpecialChar(name);
		this.name = name;
	}
}
