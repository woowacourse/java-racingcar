package racingcar.io;

import java.util.Iterator;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.vo.Name;
import racingcar.vo.Winners;

public class Output {
    private static final String NAME_DELIMITER = ", ";

    public void printCurrentPosition(Iterator<Car> cars) {
        cars.forEachRemaining(this::printRacingProgress);
        System.out.println();
    }

    private void printRacingProgress(Car car) {
        System.out.printf("%s : %s%n", car.getName(), getPositionString(car.getPosition()));
    }

    private String getPositionString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public void printWinner(Winners winners) {
        System.out.printf("%s가 최종 우승했습니다.", winners.getWinners().stream()
            .map(Name::toString)
            .collect(Collectors.joining(NAME_DELIMITER)));
    }
}
