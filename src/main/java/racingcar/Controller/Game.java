package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.Domain.Car;
import racingcar.Domain.Cars;
import racingcar.Domain.Name;
import racingcar.Domain.TrialTime;
import racingcar.Util.RandomNumberUtils;
import racingcar.Util.StringUtils;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import static java.util.stream.Collectors.joining;

/**
 * 클래스 이름 : Game.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class Game {
	private static final int INDEX_START = 0;
	private static final String NAME_DIVIDER = ", ";

	private Cars cars;
	private final TrialTime trialTime;

	public Game() {
		List<Car> separatedCars = new ArrayList<>();

		String inputCarName = InputView.inputCarName();
		List<String> carNames = StringUtils.splitCarNames(inputCarName);
		carNames = StringUtils.trimCarNames(carNames);
		carNames.forEach(carName -> separatedCars.add(new Car(carName)));
		cars = new Cars(separatedCars);
		int inputTrialTime = InputView.inputTrialTime();
		this.trialTime = new TrialTime(inputTrialTime);
	}

	public void race() {
		OutputView.printResultMessage();
		for (int index = INDEX_START, end = trialTime.getTrialTime(); index < end; index++) {
			raceOneRound();
			OutputView.printNewLine();
		}
	}

	private void raceOneRound() {
		for (Car car : cars.getCars()) {
			car.goOrNot(RandomNumberUtils.createRandomNumber());
			car.showCurrentPosition();
		}
	}

	public void showWinner() {
		int topCarPosition = cars.findTopCarPosition();
		List<Name> winners = cars.findWinners(topCarPosition);
		String winnersOutput = winners.stream()
				.map(Name::getName)
				.map(String::valueOf)
				.collect(joining(NAME_DIVIDER));
		OutputView.printWinners(winnersOutput);
	}
}
