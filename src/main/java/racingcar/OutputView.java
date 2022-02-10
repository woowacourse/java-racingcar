package racingcar;

import static java.lang.String.join;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String PRINT_WINNER_DELIMITER = ", ";
    private static final String PRINT_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public OutputView() {
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.println(join(PRINT_WINNER_DELIMITER, winnerNames) + PRINT_WINNER_MESSAGE);
    }

    public void printCarsPosition(List<RacingCarDto> cars) {
        cars.forEach(this::printCarPosition);
    }

    private void printCarPosition(RacingCarDto car) {
        System.out.print(car.getName() + " : " + getCarPosistionBar(car.getPosition()));
    }

    private String getCarPosistionBar(int position) {
        return IntStream.range(0, position)
            .mapToObj(value -> "-")
            .collect(Collectors.joining());
    }
}