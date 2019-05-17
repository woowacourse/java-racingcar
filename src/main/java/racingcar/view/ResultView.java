package racingcar.view;

import racingcar.constant.MessageConstants;
import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printHypen(car));
        }

        System.out.println();
    }

    public static String printHypen(Car car) {
        return String.format(MessageConstants.RESULT_PRINT_HYPHEN_FORMAT,
                car.getName(), getHyphen(car.getPosition()));
    }

    public static String printWinner(List<String> winners) {
        return String.format(MessageConstants.RESULT_PRINT_WINNER_FORMAT,
                String.join(",", winners));
    }

    private static String getHyphen(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

}
