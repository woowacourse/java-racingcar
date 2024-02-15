package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;

public class OutputView {
    private static final String RESULT = "\n실행 결과";
    public static final String WINNERS = "%s가 최종 우승했습니다.";

    public void printResult(List<String> result) {
        System.out.println(RESULT);
        System.out.println(String.join("\n", result));
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.printf(String.format(WINNERS, winnerNames));
    }
}
