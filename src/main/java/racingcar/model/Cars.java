package racingcar.model;

import static racingcar.utlis.RandomNumberGenerator.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.utlis.Convertor;

public class Cars {

	private static final int MINIMUM_NAME_LIST_SIZE = 1;
	private static final String INPUT_STRING_NULL_ERROR_MSG = "빈 값이 입력되었습니다.";
	private static final String CAR_NUMBER_IS_ONE_WARNING_MSG = "경주할 자동차가 한 대일 경우 경주를 진행할 수 없습니다.";
	private static final String NAME_DUPLICATION_WARNING_MSG = "중복되는 이름이 존재합니다.";

	private List<RacingCar> cars;

	public Cars(List<RacingCar> cars) {
		this.cars = cars;
	}

	public List<RacingCar> getCars() {
		return cars;
	}

	public void saveCars(String inputCarNames) {
		checkNull(inputCarNames);
		List<String> carNames = Arrays.asList(Convertor.separateNamesByDelimiter(inputCarNames));
		save(carNames);
	}

	private void save(List<String> carNames) {
		checkNameList(carNames);
		this.cars = carNames.stream().map(RacingCar::new).collect(Collectors.toList());
	}

	public void startRound() {
		cars.forEach(car -> car.decideMove(getRandomInt()));
	}

	private void checkNull(String inputString) {
		if (inputString == null || inputString.trim().isEmpty()) {
			throw new IllegalArgumentException(INPUT_STRING_NULL_ERROR_MSG);
		}
	}

	private void checkNameList(List<String> carNames) {
		checkNameIsOne(carNames);
		checkDuplicatedName(carNames);
	}

	private void checkNameIsOne(List<String> nameList) {
		if (nameList.size() <= MINIMUM_NAME_LIST_SIZE) {
			throw new IllegalArgumentException(CAR_NUMBER_IS_ONE_WARNING_MSG);
		}
	}

	private void checkDuplicatedName(List<String> nameList) {
		Set<String> nameSet = new HashSet<>(nameList);
		if (nameSet.size() != nameList.size()) {
			throw new IllegalArgumentException(NAME_DUPLICATION_WARNING_MSG);
		}
	}
}
