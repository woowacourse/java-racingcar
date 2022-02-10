package racingcar.model;

import racingcar.service.RandomNumberService;

public class Car {
	private String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Car car = (Car)obj;
		return this.name.equals(car.name);
	}

	public void move() {
		if (checkMovingCondition(RandomNumberService.getRandomNumber())) {
			position += 1;
		}
	}

	public boolean checkMovingCondition(int randomNumber) {
		return randomNumber >= 4;
	}

	@Override
	public String toString() {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < position; i++) {
			line.append("-");
		}
		return name + " : " + line.toString();
	}
}
