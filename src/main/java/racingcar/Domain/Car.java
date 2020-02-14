package racingcar.Domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

import racingcar.Util.RandomNumberUtils;
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
	private static final int INITIAL_POSITION = 0;
	public static final String DASH = "-";
	public static final String COLON = " : ";
	public static final String NAME_DIVIDER = ", ";

	public static List<String> winners = new ArrayList<>();

	private Name carName;
	private int position;

	public Car(final String carName) {
		this.carName = new Name(carName);
		this.position = INITIAL_POSITION;
	}

	public Car(final String carName, final int position) {
		this.carName = new Name(carName);
		this.position = position;
	}

	public void goOrNot() {
		if (isGo(RandomNumberUtils.createRandomNumber())) {
			position++;
		}
	}

	public boolean isGo(final int randomNumber) {
		return randomNumber >= CRITERIA_FOR_GO;
	}


	public boolean comparePosition(final Car target) {
		return this.position > target.position;
	}

	public void showCurrentPosition() {
		StringBuilder outputValue = new StringBuilder();
		outputValue.append(carName.getName()).append(COLON);
		for (int index = 0; index < position; index++) {
			outputValue.append(DASH);
		}
		OutputView.printPositionByDash(outputValue.toString());
	}

	public void findWinners(final Car car) {
		if (this.position == car.position) {
			winners.add(car.carName.getName());
		}
	}

	public String getWinners() {
		return winners.stream()
				.map(String::valueOf)
				.collect(joining(NAME_DIVIDER));
	}

	;
}
