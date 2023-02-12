package view;

import java.util.List;
import model.car.Car;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printResultMessage() {
        System.out.println(Message.OUTPUT_RESULT_MESSAGE.message);
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf(Message.OUTPUT_RESULT_FORMAT.message, car.getName(), createResultDisplay(car));
        }
        System.out.println();
    }

    private static String createResultDisplay(Car car) {
        return Message.OUTPUT_LINES.message.repeat(car.getPosition());
    }

    public void printWinners(List<String> winners) {
        System.out.printf(Message.OUTPUT_WINNER.message, String.join(", ", winners));
    }

    private enum Message {
        OUTPUT_RESULT_MESSAGE("실행 결과"),
        OUTPUT_RESULT_FORMAT("%s : %s%n"),
        OUTPUT_LINES("-"),
        OUTPUT_WINNER("%s가 최종 우승했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
