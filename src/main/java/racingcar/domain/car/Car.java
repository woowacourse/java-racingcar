package racingcar.domain.car;

import racingcar.domain.car.condition.ForwardCondition;
import racingcar.utils.Delimiter;

public class Car {

	private final String name;
	private int location;

	public Car(String name) {
		this.name = name;
	}

	public boolean isPossibleToGoForward(int number) {
		return (ForwardCondition.isInRange(number));
	}

	public void goForward() {
		this.location++;
	}

	public String getName() {
		return this.name;
	}

	public int getLocation() {
		return this.location;
	}

	public String toString() {
		return Delimiter.concatWithColon(name, Delimiter.repeatUnderBar(location));
	}

}
