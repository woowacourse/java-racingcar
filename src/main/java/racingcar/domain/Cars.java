package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.util.RandomUtil;

public class Cars {
	public static final int MINIMUM_PLAYER = 1;
	public static final int FIRST = 0;

	private List<Car> cars;

	public Cars(List<Car> cars) {
		if (cars.size() <= MINIMUM_PLAYER) {
			throw new IllegalArgumentException();
		}
		this.cars = cars;
	}

	public Car getCarOnMaxPosition() {
		return Collections.max(cars);
	}

	public void move(Times times) {
		while (!times.isDone()) {
			eachCarsMove();
			times.reduce();
			System.out.println(this);
		}
	}

	private void eachCarsMove() {
		for (Car car : cars) {
			car.move(RandomUtil.random());
		}
	}

	public List<Car> getWinners() {
		List<Car> winner = new ArrayList<>();
		Car max = getCarOnMaxPosition();
		for (Car car : cars) {
			if (max.isOnSamePosition(car))
				winner.add(car);
		}
		return winner;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car);
		}
		return sb.toString();
	}
}
