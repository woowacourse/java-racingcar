package racingcar.model.car;

import java.util.Objects;

import racingcar.dto.CarDto;

public class Car implements Comparable<Car> {
	private final Name name;
	private Position position;

	private Car(Name name, Position position) {
		this.name = name;
		this.position = position;
	}

	public static Car from(String name) {
		return new Car(Name.from(name), Position.create());
	}

	public static Car of(String name, int position) {
		return new Car(Name.from(name), Position.from(position));
	}

	public void move() {
		position = position.increase();
	}

	public CarDto toDto() {
		return new CarDto(name.toString(), position.toInt());
	}

	public Position getPosition() {
		return position;
	}

	public Name getName() {
		return name;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Car car = (Car)object;
		return name.equals(car.name);
	}

	@Override
	public int compareTo(Car car) {
		return position.compareTo(car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
