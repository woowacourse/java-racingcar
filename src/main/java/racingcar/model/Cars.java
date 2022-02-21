package racingcar.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

	private static final int MINIMUM_NAME_LIST_SIZE = 1;
	private static final String CAR_NUMBER_IS_ONE_WARNING_MSG = "경주할 자동차가 한 대 이하일 경우 경주를 진행할 수 없습니다.";
	private static final String NAME_DUPLICATION_WARNING_MSG = "중복되는 이름이 존재합니다.";
	private static final String CARS_SIZE_ERROR_MSG = "자동차 목록이 비어있습니다!";

	private final List<RacingCar> cars;

	public List<RacingGameRecord> getPresentCars() {
		return cars.stream().map(RacingGameRecord::from).collect(Collectors.toList());
	}

	public Cars(final List<RacingCar> cars) {
		checkNameList(cars);
		this.cars = cars;
	}

	public static Cars from(final List<String> carNames) {
		return new Cars(carNames.stream().map(RacingCar::createRandomMoveCar).collect(Collectors.toList()));
	}

	private void checkNameList(final List<RacingCar> cars) {
		checkNameIsOne(cars);
		checkDuplicatedName(cars);
	}

	private void checkNameIsOne(final List<RacingCar> cars) {
		if (cars.size() <= MINIMUM_NAME_LIST_SIZE) {
			throw new IllegalArgumentException(CAR_NUMBER_IS_ONE_WARNING_MSG);
		}
	}

	private void checkDuplicatedName(final List<RacingCar> cars) {
		Set<String> nameSet = cars.stream().map(RacingCar::getName).collect(Collectors.toSet());
		if (nameSet.size() != cars.size()) {
			throw new IllegalArgumentException(NAME_DUPLICATION_WARNING_MSG);
		}
	}

	public void startRound() {
		cars.forEach(RacingCar::decideMove);
	}

	private RacingCar findMaxPosition(final List<RacingCar> cars) {
		return cars.stream()
			.reduce(RacingCar::findWinner)
			.orElseThrow(() -> new IllegalStateException(CARS_SIZE_ERROR_MSG));
	}

	public List<RacingCar> findWinner() {
		RacingCar maxPositionCar = findMaxPosition(cars);
		return cars.stream()
			.filter(car -> car.matchPosition(maxPositionCar))
			.collect(Collectors.toUnmodifiableList());
	}
}
