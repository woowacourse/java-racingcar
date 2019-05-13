package racingcar.view;

import racingcar.constant.MessageConstants;
import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printHyphen(car));
        }

        System.out.println();
    }

    public static String printHyphen(Car car) {
        return String.format(MessageConstants.RESULT_PRINT_HYPHEN_FORMAT,
                car.getName(), getHyphen(car.getPosition()));
    }

    private static String getHyphen(int position) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

    public static void printWinner(List<String> winners) {
        String winnerResult = String.join(",", winners);
        System.out.println(String.format(MessageConstants.RESULT_PRINT_WINNER_FORMAT, winnerResult));
    }

}
