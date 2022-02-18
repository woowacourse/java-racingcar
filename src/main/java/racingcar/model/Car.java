package racingcar.model;

import java.util.List;
import java.util.Objects;

import racingcar.service.CheckingService;
import racingcar.service.MovingCondition;

public class Car implements Comparable<Car> {
	public static final String ONE_STEP = "-";
	public static final String COLON = " : ";

	private String name;
	private int position;
	private MovingCondition movingCondition;

	public Car(String name, int position) {
		CheckingService.checkCarNameLength(name);
		this.name = name;
		this.position = position;
	}

	public Car(String name, MovingCondition movingCondition) {
		this(name, 0);
		this.movingCondition = movingCondition;
	}

	public void move() {
		if (movingCondition.canMove()) {
			position += 1;
		}
	}

	public boolean isSamePosition(Car otherCar) {
		return this.position == otherCar.position;
	}

	public void appendName(List<String> winnerNames) {
		winnerNames.add(name);
	}

	public String testMoveFunction(int expectedPosition) {
		if (expectedPosition == this.position) {
			return "Success!!";
		}
		return "Fail!!";
	}

	@Override
	public String toString() {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < position; i++) {
			line.append(ONE_STEP);
		}
		return name + COLON + line.toString();
	}

	@Override
	public boolean equals(Object obj) {
		Car car = (Car)obj;
		return this.name.equals(car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public int compareTo(Car o) {
		return position - o.position;
	}

}
