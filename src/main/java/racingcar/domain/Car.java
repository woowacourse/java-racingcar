package racingcar.domain;

import java.util.Objects;
import java.util.function.Function;

import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.vo.CarName;

public class Car {

	public static final String CAR_PROGRESS_BAR = "-";
	private CarName name;
	private int position = 0;
	private MovingStrategy movingStrategy;

	/**
	 * 다른 스타일의 생성자를 허용하지 않는다
	 */
	private Car() {
	}

	private Car(Builder builder) {
		this.name = builder.name;
		this.position = builder.position;
		this.movingStrategy = builder.movingStrategy;
	}

	public static class Builder {
		private CarName name;
		private int position = 0;
		private MovingStrategy movingStrategy;

		public Builder name(String name) {
			this.name = new CarName(name);
			return this;
		}

		public Builder position(int position) {
			this.position = position;
			return this;
		}

		public Builder movingStrategy(MovingStrategy movingStrategy) {
			this.movingStrategy = movingStrategy;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	public String getName() {
		return name.get();
	}

	public void move() {
		if (movingStrategy.movable()) {
			this.position++;
		}
	}

	public void move(final int movingTryCount) {
		for (int i = 0; i < movingTryCount; i++) {
			move();
		}
	}

	public boolean isSamePosition(final Car maxCar) {
		return position == maxCar.position;
	}

	public int compareNameTo(final Car other) {
		return compareTo((Car otherCar) -> this.name.get().compareTo(otherCar.name.get()), other);
	}

	public int comparePositionTo(final Car other) {
		return compareTo((Car otherCar) -> this.position - otherCar.position, other);
	}

	public int compareTo(final Function<Car, Integer> function, final Car other) {
		return function.apply(other);
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
		return name + " : " + CAR_PROGRESS_BAR.repeat(position);
	}
}
