package racingcar.view;

import java.util.LinkedList;
import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {
    private static final String BEFORE_PRINT_RESULT_ANNOUNCEMENT = System.lineSeparator() + "실행 결과";
    private static final String NAME_AND_COUNT_PREFIX = " : ";
    private static final String DISTANCE_PREFIX = "-";
    private static final String WINNER_ANNOUNCEMENT = "가 최종 우승했습니다.";
    private static final String NAME_SEPARATOR = ",";

    public void announceBeforePrintResult() {
        System.out.println(BEFORE_PRINT_RESULT_ANNOUNCEMENT);
    }

    public void printResult(List<CarDto> carDtos) {
        carDtos.forEach(carDto -> {
            System.out.print(carDto.getName());
            System.out.print(NAME_AND_COUNT_PREFIX);
            printMovedDistance(carDto.getMovedCount());
        });
        System.out.println();
    }

    private void printMovedDistance(int movedCount) {
        for (int index = 0; index < movedCount; index++) {
            System.out.print(DISTANCE_PREFIX);
        }
        System.out.println();
    }

    public void printWinner(List<CarDto> winnerDtos) {
        List<String> winnerNames = new LinkedList<>();
        winnerDtos.forEach(winnerDto -> {
            winnerNames.add(winnerDto.getName());
        });
        System.out.print(String.join(NAME_SEPARATOR, winnerNames));
        System.out.println(WINNER_ANNOUNCEMENT);
    }

}
