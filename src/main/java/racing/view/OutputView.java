package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.Cars;

public class OutputView {
    private static final String RESULT = "\n실행 결과";
    public static final String WINNERS = "%s가 최종 우승했습니다.";

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.printf(String.format(WINNERS, winnerNames));
    }

    public void printResult(){
        System.out.println(RESULT);
    }
    public void printOngoingResult(List<Car> rawResult) {
        String result = rawResult.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n", "", "\n"));
        System.out.println(result);
    }
}
