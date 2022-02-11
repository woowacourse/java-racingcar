package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.vo.Car;
import racingcar.model.vo.Name;

public class OutputView {
    public static void printCurrentPosition(List<Car> cars) {
        cars.forEach(OutputView::printRacingProgress);
        System.out.println();
    }

    private static void printRacingProgress(Car car) {
        System.out.printf("%s : %s%n", car.getName(), getPositionString(car.getPosition()));
    }

    private static String getPositionString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public static void printWinner(List<Name> winners) {
        String winnersJoinedByComma = winners.stream()
            .map(Name::toString)
            .collect(Collectors.joining(", "));
        System.out.printf("%s가 최종 우승했습니다.", winnersJoinedByComma);
    }
}
