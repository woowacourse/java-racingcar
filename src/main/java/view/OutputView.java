package view;

import java.util.List;
import model.Car;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }


    public void printResultMessage() {
        System.out.println(Message.OUTPUT_RESULT_MESSAGE.message);
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < car.getPosition(); i++) {
                result.append("-");
            }
            System.out.printf(Message.OUTPUT_RESULT_FORMAT.message, car.getName(), result);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.printf(Message.OUTPUT_WINNER.message, String.join(", ", winners));
    }

    private enum Message {
        OUTPUT_RESULT_MESSAGE("실행 결과"),
        OUTPUT_RESULT_FORMAT("%s : %s%n"),
        OUTPUT_WINNER("%s가 최종 우승했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
