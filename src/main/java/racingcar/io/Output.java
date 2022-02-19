package racingcar.io;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.vo.Name;
import racingcar.domain.Winners;

public class Output {
    private static final String NAME_DELIMITER = ", ";
    private static final String CAR_ADVANCE_EXPRESSION = "-";

    public void printCurrentPosition(List<Car> cars) {
        cars.forEach(this::printRacingProgress);
        System.out.println();
    }

    public void printWinner(Winners winners) {
        System.out.printf("%s가 최종 우승했습니다.", winners.getWinners().stream()
            .map(Name::value)
            .collect(Collectors.joining(NAME_DELIMITER)));
    }

    private void printRacingProgress(Car car) {
        System.out.printf("%s : %s%n", car.getName().value(), getPositionString(car.getPosition()));
    }

    private String getPositionString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(CAR_ADVANCE_EXPRESSION);
        }
        return builder.toString();
    }
}
