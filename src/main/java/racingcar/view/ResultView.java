package racingcar.view;

import racingcar.constant.MessageConstants;
import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            printHyphen(car);
        }

        System.out.println();
    }

    private void printHyphen(Car car) {
        String hyphenString = String.format(MessageConstants.RESULT_PRINT_HYPHEN_FORMAT,
                car.getName(), getHyphen(car.getPosition()));

        System.out.println(hyphenString);
    }

    private String getHyphen(int position) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

    public void printWinner(List<String> winners) {
        String winnerResult = String.join(",", winners);
        System.out.println(String.format(MessageConstants.RESULT_PRINT_WINNER_FORMAT, winnerResult));
    }

}
