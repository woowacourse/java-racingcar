package racingCar;

import java.util.Scanner;

public class RacingCar {

	public void start() {
		RacingCarNames();
	}

	private void RacingCarNames() {
		String inputCarName = inputCarNames();
		String[] carNames = getCarNames(inputCarName);
	}

	private String inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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
			RacingCarNames();
		}
	}

	public void isRightLength(String name) throws RuntimeException {
		if (name.length() == 0 || name.length() > 5) {
			throw new RuntimeException();
		}
	}

}
