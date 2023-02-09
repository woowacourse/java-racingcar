package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";
    private static final String RESULT_POSTFIX = "가 최종 우승했습니다.";

    public void printPosition(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + COLON + CAR_POSITION_SIGN.repeat(car.getPosition())));
        enterLine();
    }

    public void printWinners(List<String> winners) {
        String winnerString = stringifyWinners(winners);
        System.out.print(winnerString);
        System.out.println(RESULT_POSTFIX);
    }

    private static String stringifyWinners(List<String> winners) {
        int beginIndex = 1;
        int endIndex = winners.toString().length() - 1;
        return winners.toString().substring(beginIndex, endIndex);
    }

    public void printError(Exception error) {
        System.out.println(error.getMessage());
    }

    public void enterLine() {
        System.out.println();
    }

}
