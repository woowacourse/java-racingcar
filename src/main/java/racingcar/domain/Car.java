package racingcar.domain;

import java.util.Objects;
import java.util.function.Function;

import racingcar.controller.dto.CarDto;
import racingcar.domain.strategy.FixedMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.domain.vo.CarName;

public class Car {

	private CarName name;
	private int position = 0;
	private MovingStrategy movingStrategy;

	protected Car() {
	}

	protected Car(final String name, final MovingStrategy movingStrategy) {
		this.name = new CarName(name);
		this.movingStrategy = movingStrategy;
	}

	public static Car createRandomMovingCar(final String name) {
		return new Car(name, new RandomMovingStrategy());
	}

	public static Car createFixedMovingCar(final String name) {
		return new Car(name, new FixedMovingStrategy());
	}

	public int getPosition() {
		return position;
	}

	public void move(final int distance) {
		position += distance;
	}

	public void move() {
		if (movingStrategy.movable()) {
			this.position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public boolean isSamePosition(final Car maxCar) {
		return position == maxCar.position;
	}

	public int comparePositionTo(final Car other) {
		return compareTo((Car otherCar) -> this.position - otherCar.position, other);
	}

	public int compareNameTo(final Car other) {
		return compareTo((Car otherCar) -> this.name.get().compareTo(other.name.get()), other);
	}

	public int compareTo(final Function<Car, Integer> function, final Car other) {
		return function.apply(other);
	}

	public CarDto toDto() {
		return new CarDto(name, position);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "Car{" +
			"name=" + name +
			", position=" + position +
			", movingStrategy=" + movingStrategy +
			'}';
	}
}