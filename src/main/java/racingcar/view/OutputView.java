package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.CarDto;

public class OutputView {
    private static final String NAME_AND_SCORE_DELIMITER = " : ";
    private static final String DRIVE_SCORE_VIEW = "-";
    private static final String NAME_DELIMITER = ", ";
    private static final String RACE_RECORD_MESSAGE = "실행 결과";
    private static final String RACE_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String ERROR = "[ERROR] ";

    public static void printRacingRecordHeadLine() {
        System.out.println();
        System.out.println(RACE_RECORD_MESSAGE);
    }

    public static void printRacingRecord(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(
                    car.getName().getNameValue() + NAME_AND_SCORE_DELIMITER + printDash(
                            car.getPosition().getPositionValue()));
        }
        System.out.println();
    }

    private static String printDash(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(DRIVE_SCORE_VIEW);
        }
        return stringBuilder.toString();
    }

    public static void printRacingResult(List<CarDto> carsOfWinner) {
        System.out.println(collectingResult(carsOfWinner) + RACE_WINNER_MESSAGE);
    }

    private static String collectingResult(List<CarDto> cars) {
        return cars.stream()
                .map(car -> car.getName().toString())
                .collect(Collectors.joining(NAME_DELIMITER));
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR + e.getMessage());
    }

    static void printRequestInstruction(String requestRoundValue) {
        System.out.println(requestRoundValue);
    }
}
