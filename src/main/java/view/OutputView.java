package view;

import domain.RandomMovingCar;
import domain.RandomMovingCars;
import domain.Winners;

import java.util.StringJoiner;

public class OutputView {
    private static final String MOVE_EXPRESS = "-";
    private static final String WINNER_NAMES_DELIMITER = ", ";

    public void printRacingResult() {
        System.out.println("\n실행 결과");
    }

    public void printRacingProceed(RandomMovingCars randomMovingCars) {
        StringBuilder builder = new StringBuilder();
        for (RandomMovingCar car : randomMovingCars.getCars()) {
            builder.append(String.format("%s : %s\n", car.getName(), MOVE_EXPRESS.repeat(car.getPosition())));
        }
        System.out.println(builder);
    }

    public void printWinners(Winners winners) {
        StringJoiner stringJoiner = new StringJoiner(WINNER_NAMES_DELIMITER);
        for (String winner : winners.getWinners()) {
            stringJoiner.add(winner);
        }

        System.out.printf("%s가 최종 우승했습니다.", stringJoiner);
    }
}
