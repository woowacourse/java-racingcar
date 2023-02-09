package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INFO_SHOW_MESSAGE = "실행결과";
    private static final String WINNER_SHOW_POSTFIX_MESSAGE = "가 최종 우승했습니다.";
    private static final String LINE_CHANGE_MESSAGE = "";

    public void showInfoMessage() {
        printMessage(INFO_SHOW_MESSAGE);
    }

    public void showCars(List<Car> cars) {
        cars.forEach(System.out::println);
        printMessage(LINE_CHANGE_MESSAGE);
    }

    public void showWinner(List<Car> cars) {
        printMessage(getWinnerNames(cars) + WINNER_SHOW_POSTFIX_MESSAGE);
    }

    private static String getWinnerNames(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
