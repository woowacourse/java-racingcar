package view;

import domain.RandomMovingCar;
import domain.RandomMovingCars;
import domain.Winners;

import java.util.StringJoiner;

public class OutputView {
    private static final String CAR_POSITION_SIGN = "-";
    private static final String WINNER_NAMES_DELIMITER = ", ";

    public void printRacingResult() {
        System.out.println("\n실행 결과");
    }

    public void printRacingResult(RandomMovingCars randomMovingCars) {
        for (RandomMovingCar car : randomMovingCars.getCars()) {
            String carPositionExpression = CAR_POSITION_SIGN.repeat(car.getPosition());
            System.out.printf("%s : %s\n", car.getName(), carPositionExpression);
        }
    }

    public void printWinners(Winners winners) {
        StringJoiner winnerNames = new StringJoiner(WINNER_NAMES_DELIMITER);
        for (String winner : winners.getWinners()) {
            winnerNames.add(winner);
        }

        System.out.printf("%s가 최종 우승했습니다.", winnerNames);
    }
}
