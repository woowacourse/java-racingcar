package racingcar.io;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarValue;
import racingcar.vo.Name;
import racingcar.dto.Winners;

public class Output {
    private static final String NAME_DELIMITER = ", ";

    public void printCurrentPosition(List<CarValue> cars) {
        cars.forEach(this::printRacingProgress);
        System.out.println();
    }

    private void printRacingProgress(CarValue car) {
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
