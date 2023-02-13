package domain;

import java.util.ArrayList;
import java.util.List;

import domain.strategy.RandomNumberStrategy;

public class Cars {
	private static final RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();

	private final List<Car> cars;

	public Cars(List<Car> input) {
		this.cars = new ArrayList<>(input);
	}

	public int getCarsSize() {
		return this.cars.size();
	}

	public void move() {
		cars.forEach(car -> car.move(randomNumberStrategy.movable()));
	}

	public Car getCar(int index) {
		return this.cars.get(index);
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
