package racingcar.models;

import racingcar.utils.RandomNumber;

public class CarMockDontGoForward extends Car {

	public CarMockDontGoForward(String name) {
		super(name);
	}

	@Override
	protected int generateRandomNumber() {
		int randomNumber = 10;
		while(randomNumber >= 4) {
			randomNumber = RandomNumber.getRandomNumber();
		}
		return randomNumber;
	}
}
