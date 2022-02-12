package racingcar.model;

import java.util.List;

import racingcar.service.RandomNumberService;

public class Car implements Comparable<Car> {
	private static final String ONE_STEP = "-";
	private static final String COLON = " : ";
	private static final int MOVING_CONDITION_NUMBER = 4;
	private final String name;
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

	@Override
	public String toString() {
		String step = ONE_STEP;
		step = step.repeat(position);
		return name + COLON + step;
	}

	@Override
	public int compareTo(Car other) {
		return position - other.position;
	}

	public void move() {
		if (checkMovingCondition(RandomNumberService.getRandomNumber())) {
			position += 1;
		}
	}

	public boolean checkMovingCondition(int randomNumber) {
		return randomNumber >= MOVING_CONDITION_NUMBER;
	}

	public boolean isSamePosition(Car otherCar) {
		return this.position == otherCar.position;
	}

	public void appendName(List<String> winnerNames) {
		winnerNames.add(name);
	}
}
