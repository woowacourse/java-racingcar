package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import java.util.List;
import racingcar.domain.RacingGame;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String CAR_RESULT_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE_FORMAT = "가 최종 우승했습니다.";
    private static final String NAME_DELIMITER = ", ";
    private static final String POSITION_PRINT_FORMAT = "-";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(List<Cars> cars) {
        for (Cars roundTotalCarResult : cars) {
            printRoundResult(roundTotalCarResult);
        }
    }

    public void printFinalResult(RacingGame racingGame) {
        List<String> winners = racingGame.getWinners();
        String winningCarNames = String.join(NAME_DELIMITER, winners);
        System.out.print(winningCarNames + WINNER_MESSAGE_FORMAT);
    }

    private void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format(CAR_RESULT_FORMAT, car.getName(), getCurrentCarPosition(car)));
        }
        System.out.println();
    }

    private String getCurrentCarPosition(Car car) {
        return POSITION_PRINT_FORMAT.repeat(car.getPosition());
    }

}
