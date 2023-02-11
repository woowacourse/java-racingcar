package view;

import model.Car;
import model.Racing;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String RESULT_HEADER = "실행 결과";
    private static final String WIN_MENTION = "%s가 최종 우승했습니다.%n";
    private static final String WINNER_CONNECTOR = ", ";

    public void resultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void result(Racing racing) {
        System.out.println(racing);
    }

    public void winner(List<Car> winners) {
        System.out.printf(WIN_MENTION, winnersToString(winners));
    }

    private String winnersToString(List<Car> winners) {
        return winners.stream()
                .map(Car::toString)
                .collect(joining(WINNER_CONNECTOR));
    }
}
