package view;

import model.Car;
import model.Racing;

import java.util.List;

import static java.util.stream.Collectors.*;

public class OutputView {

    private final String RESULT = "실행 결과";
    private final String WIN_MENTION = "%s가 최종 우승했습니다.%n";

    public void result() {
        System.out.println(RESULT);
    }

    public void makeResult(Racing racing) {
        System.out.println(racing);
    }

    public void winner(List<Car> winners) {
        System.out.printf(WIN_MENTION, getWinners(winners));
    }

    public String getWinners(List<Car> winners) {
        return winners.stream()
                .map(Car::toString)
                .collect(joining(", "));
    }

}
