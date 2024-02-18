package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.List;

public class OutputView {
    private static final String NEWLINE = System.lineSeparator();
    private static final String RESULT_MESSAGE = NEWLINE + "실행 결과";
    private static final String COLON = " : ";
    private static final String POSITION_EXPRESSION_SYMBOL = "-";
    private static final String WINNERS_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ", ";
    private static final String ERROR_SUFFIX = "[ERROR]";
    private static final String ERROR_MESSAGE_FORMAT = "%s %s";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(final List<CarsDto> raceResult) {
        raceResult.forEach(carsDto -> printRoundResult(carsDto.getCars()));
    }

    public static void printRoundResult(final List<CarDto> cars) {
        cars.forEach(OutputView::printCarInformation);
        System.out.println();
    }

    private static void printCarInformation(final CarDto car) {
        final StringBuilder informationBuilder = new StringBuilder();

        informationBuilder.append(car.getName())
                .append(COLON)
                .append(POSITION_EXPRESSION_SYMBOL.repeat(car.getPosition()));

        System.out.println(informationBuilder);
    }

    public static void printWinners(final List<CarDto> winners) {
        final List<String> winnerNames = findWinnerNames(winners);
        final String names = String.join(WINNER_DELIMITER, winnerNames);

        System.out.println(names.concat(WINNERS_MESSAGE));
    }

    private static List<String> findWinnerNames(final List<CarDto> winners) {
        return winners.stream()
                .map(CarDto::getName)
                .toList();
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, ERROR_SUFFIX, errorMessage));
    }
}
