package view;

import dto.CarDto;
import dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String CAR_POSITION_MARK = "-";
    private static final String WINNERS_NAME_DELIMITER = ", ";

    public static void printRaceProcess(final List<ResultDto> raceProcess) {
        System.out.println("\n실행 결과");
        raceProcess.forEach(OutputView::printCarsPositionSingleAttempt);
    }

    public static void printResult(final List<CarDto> winners) {
        if (winners.size() == 0) {
            System.out.println("우승자가 없습니다.");
            return;
        }

        final List<String> winnerNames = winners.stream()
                .map(CarDto::name)
                .collect(Collectors.toList());

        final String result = String.join(WINNERS_NAME_DELIMITER, winnerNames).concat("가 최종 우승했습니다.");
        System.out.println(result);
    }

    public static void printExceptionMessage(final Exception ex) {
        System.out.println(ex.getMessage());
    }

    private static void printCarsPositionSingleAttempt(final ResultDto singleAttemptResult) {
        singleAttemptResult.carGroup().forEach(carDto -> {
                    String carName = carDto.name();
                    int position = carDto.position();
                    System.out.println(carName + " : " + CAR_POSITION_MARK.repeat(position));
                }
        );
        System.out.println();
    }
}
