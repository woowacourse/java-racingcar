package racingcar.models;

import racingcar.utils.RandomNumber;

public class CarMockGoForward extends Car {

	public CarMockGoForward(String name) {
		super(name);
	}

	@Override
	protected int generateRandomNumber() {
		int randomNumber = 0;
		while(randomNumber <= 3) {
			randomNumber = RandomNumber.getRandomNumber();
		}
		return randomNumber;
	}
}
