package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.Cars;

public class OutputView {

    private static final String PRINT_RESULT = "\n실행 결과";
    private static final String CAR_FORMAT = "%s : %s";
    private static final String POSITION_MARKER = "-";
    private static final String WINNERS_FORMAT = "%s가 최종 우승했습니다.";

    public void printResult(List<Cars> result) {
        System.out.println(PRINT_RESULT);
        for (Cars cars : result) {
            List<String> roundResult = cars.getCars().stream()
                    .map(car -> String.format(CAR_FORMAT, car.getName(), POSITION_MARKER.repeat(car.getPosition())))
                    .toList();
            System.out.println(String.join("\n", roundResult) + "\n");
        }
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.printf(String.format(WINNERS_FORMAT, winnerNames));
    }
}
