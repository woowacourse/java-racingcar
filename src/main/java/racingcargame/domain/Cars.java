package racingcargame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcargame.exception.CarsNameInputException;
import racingcargame.view.OutputView;

public class Cars {
	public static final String CAR_NAMES_DELIMITER = ",";
	public static final String BLANK = "";

	private final List<Car> cars = new ArrayList<>();

	public Cars(List<Car> cars) {
		this.cars.addAll(cars);
	}

	public static Cars create(String inputCarNames) {
		checkCarAmount(inputCarNames);
		String[] separatedCarNames = inputCarNames.split(CAR_NAMES_DELIMITER);
		checkDuplicatedNames(separatedCarNames);
		List<Car> cars = createCars(separatedCarNames);
		return new Cars(cars);
	}

	private static void checkCarAmount(String inputCarNames) {
		checkNoCars(inputCarNames);
		checkOnlyOneCar(inputCarNames);
	}

	private static void checkNoCars(String inputCarNames) {
		if (BLANK.equals(inputCarNames)) {
			OutputView.printNoCarErrorMessage();
			throw new CarsNameInputException("※자동차 이름이 입력되지 않음");
		}
	}

	private static void checkOnlyOneCar(String inputCarNames) {
		if (!inputCarNames.contains(CAR_NAMES_DELIMITER)) {
			OutputView.printOnlyOneCarErrorMessage();
			throw new CarsNameInputException("※자동차 이름이 한 개만 입력됨");
		}
	}

	private static void checkDuplicatedNames(String[] separatedCarNames) {
		Set<String> carNames = Arrays.stream(separatedCarNames)
									 .map(String::trim)
									 .collect(Collectors.toSet());
		if (carNames.size() != separatedCarNames.length) {
			OutputView.printDuplicatedNameErrorMessage();
			throw new CarsNameInputException("※중복되는 자동차 이름이 존재");
		}
	}

	private static List<Car> createCars(String[] separatedCarNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : separatedCarNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}

	public void move() {
		cars.forEach(car -> car.go(Engine.create()));
	}

	public List<Car> extractWinners() {
		List<Car> cars = this.cars;
		Collections.sort(cars);
		Car topPositionCar = cars.get(cars.size() - 1);
		List<Car> winners = cars.stream()
								.filter(car -> car.isSamePositionWith(topPositionCar))
								.collect(Collectors.toList());
		return Collections.unmodifiableList(winners);
	}

	public List<Car> getUnmodifiableCars() {
		return Collections.unmodifiableList(cars);
	}
}
