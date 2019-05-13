package racinggame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
	private final Cars cars;

	public static final int RANDOM_MAX = 10;
	private static final Random RANDOM = new Random();
	private static final String DUPLICATED_NAME_EXCEPTION_MESSAGE = "중복되지 않은 이름을 입력해주세요.";
	private static final String NULL_NAMES_LENGTH_EXCEPTION_MESSAGE = "올바른 이름을 입력해주세요.";

	public RacingGame(String[] carNames) {
		if (hasDuplicatedNames(carNames)) {
			throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION_MESSAGE);
		}
		if (carNames.length == 0) {
			throw new IllegalArgumentException(NULL_NAMES_LENGTH_EXCEPTION_MESSAGE);
		}
		this.cars = new Cars(Arrays.stream(carNames).map(name -> new Car(name)).collect(Collectors.toList()));
	}

	public Cars getCars() {
		return cars;
	}

	public void addCar(Car car) {
		cars.addCar(car);
	}

	public void playOneRound() {
		for (Car car : cars) {
			car.move(getRandomNumber());
		}
	}

	public Winners getWinners() {
		int maxPosition = cars.getMaxPosition();
		return new Winners(cars, maxPosition);
	}

	public int getRandomNumber() {
		return RANDOM.nextInt(RANDOM_MAX);
	}

	public boolean hasDuplicatedNames(String[] carNames) {
		;
		List<String> names = Arrays.stream(carNames).collect(Collectors.toList());
		return !(names.size() == new HashSet<String>(names).size());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RacingGame other = (RacingGame) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		return true;
	}
}
