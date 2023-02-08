package view.output;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private final String RACING_RESULT_MESSAGE = System.lineSeparator() + "실행 결과";
    private final String RACING_WINNER_MESSAGE = "%s가 최종 우승했습니다." + System.lineSeparator();

    public void printRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            StringJoiner stringJoiner = new StringJoiner(" : ");
            makeCarNames(car, stringJoiner);
            makeCarTrack(car, stringJoiner);

            System.out.println(stringJoiner);
        }
        System.out.println();
    }

    private void makeCarNames(Car car, StringJoiner stringJoiner) {
        stringJoiner.add(car.getCarName());
    }

    private void makeCarTrack(Car car, StringJoiner stringJoiner) {
        stringJoiner.add("-".repeat(car.getPosition()));
    }

    public void printRacingWinners(List<Car> cars) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        cars.forEach(car -> stringJoiner.add(car.getCarName()));

        System.out.printf(RACING_WINNER_MESSAGE, stringJoiner);
    }

    public void printGameResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }
}