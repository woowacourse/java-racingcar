package view;

import message.Constant;
import model.Car;
import model.Racing;

import java.util.List;

import static java.util.stream.Collectors.*;

public class OutputView {

    public void resultHeader() {
        System.out.println(Constant.RESULT_HEADER);
    }

    public void result(Racing racing) {
        System.out.println(racing);
    }

    public void winner(List<Car> winners) {
        System.out.printf(Constant.WIN_MENTION, winnersToString(winners));
    }

    private String winnersToString(List<Car> winners) {
        return winners.stream()
                .map(Car::toString)
                .collect(joining(Constant.WINNER_CONNECTOR));
    }
}
