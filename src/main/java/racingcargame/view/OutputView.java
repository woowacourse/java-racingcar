package racingcargame.view;

import racingcargame.model.Car;

import java.util.List;

public class OutputView {
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다";
    private static final String POSITION_MESSAGE = "-";
    private static final String DELIMITER = ",";

    public static void printRound(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.getName() + " : " + positionMessage(car.getPosition())));
        System.out.println();
    }

    private static String positionMessage(int carPosition) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            message.append(POSITION_MESSAGE);
        }
        return message.toString();
    }

    public static void printGameResult(List<String> winnerList) {
        System.out.println(String.join(DELIMITER, winnerList) + WINNER_MESSAGE);
    }
}
