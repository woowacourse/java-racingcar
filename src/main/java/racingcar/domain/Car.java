package racingcar.domain;

import java.util.Objects;
import java.util.function.Function;

import racingcar.controller.dto.CarDto;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.vo.CarName;

public class Car {

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

	public void move(final int distance) {
		position += distance;
	}

	public void move() {
		if (movingStrategy.movable()) {
			this.position++;
		}
	}

	public boolean isSamePosition(final Car maxCar) {
		return position == maxCar.position;
	}

	public int compareTo(final Function<Car, Integer> function, final Car other) {
		return function.apply(other);
	}

	public int comparePositionTo(final Car other) {
		return compareTo((Car otherCar) -> this.position - otherCar.position, other);
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