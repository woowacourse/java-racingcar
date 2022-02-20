package racingcar.model;

import static racingcar.model.RacingCar.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.utlis.Convertor;

public class Cars {

	private static final int MINIMUM_NAME_LIST_SIZE = 1;
	private static final String CAR_NUMBER_IS_ONE_WARNING_MSG = "경주할 자동차가 한 대 이하일 경우 경주를 진행할 수 없습니다.";
	private static final String NAME_DUPLICATION_WARNING_MSG = "중복되는 이름이 존재합니다.";

	private List<RacingCar> cars;

	public List<RacingCar> getCars() {
		return this.cars;
	}

	public Cars getThisRoundResult() {
		return this;
	}

	public Cars(String inputCarNames) {
		List<String> carNames = Arrays.asList(Convertor.separateNamesByDelimiter(inputCarNames));
		save(carNames);
	}

	private void save(List<String> carNames) {
		checkNameList(carNames);
		this.cars = carNames.stream().map(RacingCar::createRandomMoveCar).collect(Collectors.toList());
	}

	public void startRound() {
		cars.forEach(RacingCar::decideMove);
	}

	private int findMaxPosition(List<RacingCar> cars) {
		return cars.stream().mapToInt(RacingCar::getPosition).max().orElse(0);
	}

	public List<String> findWinner() {
		int maxPosition = findMaxPosition(cars);
		return cars.stream()
			.filter(car -> car.matchPosition(maxPosition))
			.map(RacingCar::getName)
			.collect(Collectors.toUnmodifiableList());
	}

	private void checkNameList(List<String> carNames) {
		checkNameIsOne(carNames);
		checkDuplicatedName(carNames);
	}

	private void checkNameIsOne(List<String> names) {
		if (names.size() <= MINIMUM_NAME_LIST_SIZE) {
			throw new IllegalArgumentException(CAR_NUMBER_IS_ONE_WARNING_MSG);
		}
	}

	private void checkDuplicatedName(List<String> names) {
		Set<String> nameSet = new HashSet<>(names);
		if (nameSet.size() != names.size()) {
			throw new IllegalArgumentException(NAME_DUPLICATION_WARNING_MSG);
		}
	}
}
