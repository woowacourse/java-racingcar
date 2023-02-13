package view;

import dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INFO_SHOW_MESSAGE = "실행결과";
    private static final String WINNER_SHOW_POSTFIX_MESSAGE = "가 최종 우승했습니다.";
    private static final String LINE_CHANGE_MESSAGE = "";
    private static final String JOINING_DELIMITER = ", ";

    public void showInfoMessage() {
        printMessage(INFO_SHOW_MESSAGE);
    }

    public void showCars(List<CarDto> cars) {
        cars.forEach(System.out::println);
        printMessage(LINE_CHANGE_MESSAGE);
    }

    public void showWinner(List<CarDto> cars) {
        printMessage(getWinnerNames(cars) + WINNER_SHOW_POSTFIX_MESSAGE);
    }

    private static String getWinnerNames(List<CarDto> cars) {
        return cars.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(JOINING_DELIMITER));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
