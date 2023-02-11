package view;

import dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_STATUS_FORMAT = "%s : %s\n";
    private static final String PRINT_WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String DELIMITER = ", ";
    private static final String POSITION = "-";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printStatus(final List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            String name = carDto.getName();
            int position = carDto.getPosition();
            String positionString = getPositionString(position);
            System.out.printf(PRINT_STATUS_FORMAT, name, positionString);
        }
        System.out.println();
    }

    private static String getPositionString(final int position) {
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionString.append(POSITION);
        }
        return positionString.toString();
    }

    public static void printWinners(final List<CarDto> carDtos) {
        List<String> carNames = carDtos.stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());
        String winnerString = String.join(DELIMITER, carNames);
        System.out.printf(PRINT_WINNER_FORMAT, winnerString);
    }
}
