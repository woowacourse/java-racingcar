package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final String WINNERS_DELIMITER = ",";
    private static final String WINNER_MESSAGE_FORM = "%s가 최종 우승했습니다.";

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = new ArrayList<>(winners);
    }

    @Override
    public String toString() {
        String winnersString = winners.stream()
                .map(Car::getName)
                .map(CarName::getName)
                .collect(Collectors.joining(WINNERS_DELIMITER));
        return String.format(WINNER_MESSAGE_FORM, winnersString);
    }
}
