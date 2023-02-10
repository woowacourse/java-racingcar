package view.output;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String RACING_RESULT_MESSAGE = System.lineSeparator() + "실행 결과";
    private static final String RACING_WINNER_MESSAGE = "%s가 최종 우승했습니다." + System.lineSeparator();
    private static final String DISTANCE_MARK = "-";
    private static final String CAR_INFO_DELIMITER = " : ";
    private static final String RESULT_DELIMITER = ", ";

    public void printRacingStatus(final List<Car> cars) {
        for (Car car : cars) {
            StringJoiner stringJoiner = new StringJoiner(CAR_INFO_DELIMITER);
            stringJoiner.add(makeCarNames(car));
            stringJoiner.add(makeCarTrack(car));

            System.out.println(stringJoiner);
        }
        System.out.println();
    }

    private String makeCarNames(final Car car) {
        return car.getCarName();
    }

    private String makeCarTrack(final Car car) {
        return DISTANCE_MARK.repeat(car.getPosition());
    }

    public void printRacingWinners(final List<Car> cars) {
        StringJoiner stringJoiner = new StringJoiner(RESULT_DELIMITER);
        cars.forEach(car -> stringJoiner.add(car.getCarName()));

        System.out.printf(RACING_WINNER_MESSAGE, stringJoiner);
    }

    public void printGameResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public void printExceptionMessage(final String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public static void printAnnounceMessage(final String announceMessage) {
        System.out.println(announceMessage);
    }
}
