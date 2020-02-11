package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
	private final String name;
	private int position = 0;

	public Car(String name) {
		if (isTooLongName(name))
			throw new IllegalArgumentException();
		this.name = name;
	}

	private boolean isTooLongName(String name) {
		return name.length() > 5;
	}

	public void move(int random) {
		if (isMoving(random)) {
			position++;
		}
	}

	private boolean isMoving(int random) {
		return random >= 4;
	}

	public boolean isOnSamePosition(Car anotherCar) {
		return compareTo(anotherCar) == 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return position == car.position &&
			Objects.equals(name, car.name);
	}

	@Override
	public int compareTo(Car anotherCar) {
		return anotherCar.position - position;
	}
}
