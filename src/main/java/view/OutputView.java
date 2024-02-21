package view;

import domain.Car;
import domain.RacingGame;
import domain.RoundRecord;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private static final String WIN_THE_GAME = "가 최종 우승했습니다.";
    private static final String SCORE = "-";
    private static final String SCORE_DELIMITER = ":";

    public void printResult(RacingGame racingGame) {
        printMessage(GAME_RESULT);
        printGameRecord(racingGame.getGameRecord());
        printCars(racingGame.findWinners());
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printGameRecord(List<RoundRecord> gameRecord) {
        for (RoundRecord roundRecord : gameRecord) {
            printScore(roundRecord.getCars());
        }
    }

    private void printCars(List<Car> cars) {
        String result = cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(result + WIN_THE_GAME);
    }

    private void printScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(
                car.getName() + " " + SCORE_DELIMITER + " " + SCORE.repeat(car.getScore()));
        }
        System.out.println();
    }
}
