package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT = "\n실행 결과";
    public static final String PRINT_WINNERS = "%s가 최종 우승했습니다.";

    public void printResult(List<String> result){
         System.out.println(RESULT);
         System.out.println(String.join("\n", result));
     }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.printf(String.format(PRINT_WINNERS, winnerNames));
    }
}
