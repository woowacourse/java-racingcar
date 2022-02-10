package racingcar.model;

import java.util.List;

import racingcar.service.RandomNumberService;

public class Car implements Comparable<Car> {
	private String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public Car(String name, int position) {
		this.name = name;
		this.position = position;
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

	@Override
	public int compareTo(Car o) {
		return position - o.position;
	}

	public boolean isSamePosition(Car otherCar) {
		return this.position == otherCar.position;
	}

	public void collectName(List<String> winnerNames) {
		winnerNames.add(name);
	}
}
