package racingcar.io;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.vo.Name;

public class Output {
    public void printCurrentPosition(List<Car> cars) {
        cars.forEach(this::printRacingProgress);
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

    public void printWinner(List<Name> winners) {
        String winnersJoinedByComma = winners.stream()
            .map(Name::toString)
            .collect(Collectors.joining(", "));
        System.out.printf("%s가 최종 우승했습니다.", winnersJoinedByComma);
    }
}
