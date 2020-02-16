package racingcar.io;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Winners;

public class OutputView {
	public static void printResultTitle() {
		System.out.println("실행 결과\n");
	}

	public static void printWinners(Winners winners) {
		List<String> names = winners
			.getWinners()
			.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
		String winnerNames = String.join(",", names);
		System.out.println(winnerNames + "이(가) 우승했습니다.");
	}
}
