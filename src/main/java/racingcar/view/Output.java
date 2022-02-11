package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {

	//:todo : 상수 밖으로 빼기

	private static StringBuilder stringBuilder = new StringBuilder();

	private Output() {
	}

	public static void errorMessage(String message) {
		System.out.println("[ERROR] " + message);
	}

	public static void getCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static void getAttempt() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static void roundResult(List<Car> cars) {
		for (Car car : cars) {
			stringBuilder.append(car.toString()).append("\n");
		}
		stringBuilder.append("\n");
	}

	public static void allRoundResult() {
		System.out.println("\n실행 결과");
		System.out.print(stringBuilder);
	}

	public static void showResult(List<String> winners) {
		allRoundResult();
		System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
	}
}
