package racing;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	public static void printWinner(List<Car> winners) {
		String winnersName = winners.stream().map(Car::getName).collect(Collectors.joining(","));
		System.out.print(winnersName + " 최종 우승했습니다.");
	}
}
