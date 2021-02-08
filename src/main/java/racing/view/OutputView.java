package racing.view;

import racing.dto.CarDto;

import java.util.List;

public class OutputView {
    private static final String RESULT_HEADER = "\n실행 결과";
    private static final String DISTANCE = "-";
    private static final String STATUS_FORMAT = "%s : %s\n";
    private static final String DELIMITER = ", ";
    private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final int ZERO = 0;

    private OutputView() {
    }

    public static void printGameResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printRacingTryResult(List<CarDto> carDtos) {
        carDtos.forEach(OutputView::printEachCarStatus);
        System.out.println();
    }

    private static void printEachCarStatus(CarDto carDto) {
        int position = carDto.getPosition();
        String movingDistance = drawMovingDistance(position);
        String carName = carDto.getName();
        System.out.printf(STATUS_FORMAT, carName, movingDistance);
    }

    private static String drawMovingDistance(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ZERO; i < position; i++) {
            stringBuilder.append(DISTANCE);
        }
        return stringBuilder.toString();
    }

    public static void printWinnerNames(List<String> winnerNames) {
        String winnerNamesWithDelimiter = String.join(DELIMITER, winnerNames);
        System.out.printf(WINNER_FORMAT, winnerNamesWithDelimiter);
    }
}
