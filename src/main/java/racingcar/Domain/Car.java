package racingcar.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

import racingcar.View.OutputView;

/**
 * 클래스 이름 : Car.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class Car {
	private static final int CRITERIA_FOR_GO = 4;
	private static final String POSITION_INDICATOR = "-";
	private static final String COLON = " : ";
	private static final String NAME_DIVIDER = ", ";

	public static List<String> winners = new ArrayList<>();
	private final Name carName;
	private final Position position;

	public Car(final String carName) {
		this.carName = new Name(carName);
		this.position = new Position();
	}

	public Car(final String carName, final int position) {
		this.carName = new Name(carName);
		this.position = new Position(position);
	}

	public void goOrNot(final int randomNumber) {
		if (isGo(randomNumber)) {
			position.moveForward();
		}
	}

	private boolean isGo(final int randomNumber) {
		return randomNumber >= CRITERIA_FOR_GO;
	}

	public boolean comparePosition(final Car target) {
		return this.position.getPosition() > target.position.getPosition();
	}

	public void showCurrentPosition() {
		StringBuilder outputValue = new StringBuilder();
		outputValue.append(carName.getName()).append(COLON);
		for (int index = 0, position = this.getPosition().getPosition(); index < position; index++) {
			outputValue.append(POSITION_INDICATOR);
		}
		OutputView.printPositionByDash(outputValue.toString());
	}

	public boolean isSamePosition(int targetCarPosition) {
		return this.position.getPosition() == targetCarPosition;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car) o;
		return Objects.equals(carName, car.carName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName);
	}

	public Position getPosition() {
		return this.position;
	}

	public Name getCarName() {
		return this.carName;
	}

}
