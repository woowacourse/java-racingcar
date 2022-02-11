package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {
	public static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	public static final String WHAT_TIMES = "시도할 횟수는 몇회인가요?";
	public static final String NAME_ERROR = "[ERROR] 이름이 공백이거나 6자 이상이면 안됩니다. 다시 입력해주세요.";
	public static final String TIMES_ERROR = "[ERROR] 시도 횟수는 양수인 정수여야 합니다. 다시 입력해주세요.";
	public static final String RESULT = "실행결과";
	public static final String COMMA_SPACE = ", ";
	public static final String FINAL_WINNER = "가 최종 우승했습니다.";
	private ArrayList<Car> cars = new ArrayList<>();
	private int maxPosition = Integer.MIN_VALUE;
	private int times;

	public void start() {
		List<Car> winners;
		String[] carNames = racingCarNames();
		racingCarTimes();
		makeCars(carNames);
		race(times);
		winners = findWinner(cars);
		printWinners(winners);
	}

	private String[] racingCarNames() {
		String inputCarName = userInput(ENTER_CAR_NAMES);
		return makeCarNames(inputCarName);
	}

	private void racingCarTimes() {
		String inputRacingTimes = userInput(WHAT_TIMES);
		enterTimes(inputRacingTimes);
	}

	private String userInput(String message) {
		System.out.println(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public String[] makeCarNames(String input) {
		String[] carNames = splitCarNames(input);
		return getCarNames(carNames);
	}

	private String[] getCarNames(String[] carNames) {
		for (int idx = 0; idx < carNames.length; idx++) {
			carNames[idx] = carNames[idx].trim();
			checkCarName(carNames[idx]);
		}
		return carNames;
	}

	private String[] splitCarNames(String input) {
		String[] carNames = input.split(",");
		return carNames;
	}

	private void checkCarName(String name) {
		try {
			checkRightLength(name);
		} catch (RuntimeException e) {
			System.out.println(NAME_ERROR);
			racingCarNames();
		}
	}

	public void checkRightLength(String name) throws RuntimeException {
		if (isRightLength(name)) {
			throw new RuntimeException();
		}
	}

	private boolean isRightLength(String name) {
		return name.length() == 0 || name.length() > 5;
	}

	public void enterTimes(String input) {
		try {
			isRightTimes(input);
			times = Integer.parseInt(input);
		} catch (RuntimeException e) {
			System.out.println(TIMES_ERROR);
			racingCarTimes();
		}
	}

	public void isRightTimes(String input) throws RuntimeException {
		final String REGEX = "[0-9]+";
		if (!input.matches(REGEX)) {
			throw new RuntimeException();
		}
	}

	private void makeCars(String[] carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	private void race(int count) {
		System.out.println(RESULT);
		for (int i = 0; i < count; i++) {
			moveCars();
			System.out.println();
		}
	}

	private void moveCars() {
		for (int idx = 0; idx < cars.size(); idx++) {
			moveCar(idx);
		}
	}

	private void moveCar(int idx) {
		Car car = cars.get(idx);
		car.moveCar(makeRandom());
		System.out.println(car);
	}

	private boolean makeRandom() {
		return ((int)(Math.random() * 10) - 1) >= 4;
	}

	public List<Car> findWinner(List<Car> cars) {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			winners = checkLead(car, winners);
		}
		return winners;

	}

	private List<Car> checkLead(Car car, List<Car> winners) {
		if (car.getPosition() > maxPosition) {
			winners.clear();
			winners.add(car);
			maxPosition = car.getPosition();
			return winners;
		}
		if (car.getPosition() == maxPosition) {
			winners.add(car);
		}
		return winners;
	}

	private void printWinners(List<Car> winners) {
		for (int idx = 0; idx < winners.size() - 1; idx++) {
			winners.get(idx).printName();
			System.out.print(COMMA_SPACE);
		}
		winners.get(winners.size() - 1).printName();
		System.out.println(FINAL_WINNER);
	}
	
}
