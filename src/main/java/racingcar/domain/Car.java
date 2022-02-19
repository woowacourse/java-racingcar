package racingcar.domain;

import java.util.Objects;

import racingcar.service.RandomGenerator;
import racingcar.service.MovePolicy;

public class Car implements Comparable<Car> {
	private final CarName name;
	private int position = 0;

	public Car(CarName name) {
		this.name = name;
	}

	public Car(CarName name, int position) {
		this.name = name;
		this.position = position;
	}

	public void drive(MovePolicy movePolicy) {
		if (movePolicy.hasNext(RandomGenerator.generate())) {
			move();
		}
	}

	private void move() {
		position++;
	}

	public boolean isSamePosition(Car other) {
		return this.position == other.position;
	}

	public String getName() {
		return name.getName();
	}

	public int getPosition() {
		return position;
	}

	@Override
	public int compareTo(Car car) {
		return this.position - car.position;
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Car) {
			Car car = (Car)object;
			return car.name.equals(name);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
