package racingcar.domain;

import java.util.Objects;
import java.util.function.Function;

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

	protected Car(String name, MovingStrategy movingStrategy) {
		this.name = new CarName(name);
		this.movingStrategy = movingStrategy;
	}

	public static Car createRandomMovingCar(String name) {
		return new Car(name, new RandomMovingStrategy());
	}

	public static Car createFixedMovingCar(String name) {
		return new Car(name, new FixedMovingStrategy());
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name.get();
	}

	public void move(int distance) {
		position += distance;
	}

	public void move() {
		if (movingStrategy.movable()) {
			this.position++;
		}
	}

	public boolean isSamePosition(Car maxCar) {
		return position == maxCar.position;
	}

	public int comparePositionTo(Car other) {
		return compareTo((Car otherCar) -> this.position - otherCar.position, other);
	}

	public int compareNameTo(Car other) {
		return compareTo((Car otherCar) -> this.name.get().compareTo(other.getName()), other);
	}

	public int compareTo(Function<Car, Integer> function, Car other) {
		return function.apply(other);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

	@Override
	public String toString() {
		return name + " : " + "-".repeat(position);
	}
}