package view;

import model.Cars;
import model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String RESULT_HEADER = "\n실행 결과";
    private static final String WIN_MENTION = "%s가 최종 우승했습니다.%n";
    private static final String WINNER_CONNECTOR = ", ";
    private static final String STICK = "-";
    public static final String CAR_RESULT = "%s : %s\n";

    public void resultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void result(Cars racing) {
        String result = racing.getCars()
                .stream()
                .map(this::convertResultToString)
                .collect(Collectors.joining());
        System.out.println(result);
    }

    private String convertResultToString(Vehicle car) {
        return String.format(CAR_RESULT, car.getName(), STICK.repeat(car.getDistance()));
    }

    public void winner(List<Vehicle> winners) {
        System.out.printf(WIN_MENTION, convertwinnersToString(winners));
    }

    private String convertwinnersToString(List<Vehicle> winners) {
        return winners.stream()
                .map(Vehicle::getName)
                .collect(joining(WINNER_CONNECTOR));
    }
}
