package racingcar.model;

import java.util.Objects;

import racingcar.service.CheckingService;
import racingcar.service.MovingCondition;

public class Car implements Comparable<Car> {
	private String name;
	private int position;
	private MovingCondition movingCondition;

	public Car(String name, int position, MovingCondition movingCondition) {
		CheckingService.checkCarNameLength(name);
		this.name = name;
		this.position = position;
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

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
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
