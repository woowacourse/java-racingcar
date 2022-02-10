package racingCar;

import java.util.Scanner;

public class RacingCar {

	public void start() {
		String[] carNames = racingCarNames();
		int count = racingCarTimes();

	}

	private String[] racingCarNames() {
		String inputCarName = userInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return getCarNames(inputCarName);
	}

	private int racingCarTimes() {
		String inputRacingTimes = userInput("시도할 횟수는 몇회인가요?");
		return enterTimes(inputRacingTimes);
	}

	private String userInput(String message) {
		System.out.println(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public String[] getCarNames(String input) {
		String[] carNames = input.split(",");
		for (int idx = 0; idx < carNames.length; idx++) {
			carNames[idx] = carNames[idx].trim();
			checkCarName(carNames[idx]);
		}
		return carNames;
	}

	private void checkCarName(String name) {
		try {
			isRightLength(name);
		} catch (RuntimeException e) {
			System.out.println("[ERROR] 이름이 공백이거나 6자 이상이면 안됩니다. 다시 입력해주세요.");
			racingCarNames();
		}
	}

	public void isRightLength(String name) throws RuntimeException {
		if (name.length() == 0 || name.length() > 5) {
			throw new RuntimeException();
		}
	}

	public int enterTimes(String input) {
		try {
			isRightTimes(input);

		} catch (RuntimeException e) {
			System.out.println("[ERROR] 시도 횟수는 양수인 정수여야 합니다. 다시 입력해주세요.");
			racingCarTimes();
		}
		return Integer.parseInt(input);
	}

	public void isRightTimes(String input) throws RuntimeException {
		final String REGEX = "[0-9]+";
		if (!input.matches(REGEX)) {
			throw new RuntimeException();
		}
	}

}
