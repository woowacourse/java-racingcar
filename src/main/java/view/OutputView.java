package view;

import domain.Car;
import domain.RacingGame;
import domain.Round;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private static final String WIN_THE_GAME = "가 최종 우승했습니다.";

    public void printGameResult(RacingGame racingGame, Round round) {
        System.out.println(GAME_RESULT);
        for (int i = 0; i < round.getRound(); i++) {
            printScore(racingGame.playOneRound());
        }
        printCars(racingGame.findWinners());
    }

    private void printScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getScore()));
        }
        System.out.println();
    }

    private void printCars(List<Car> cars) {
        String result = cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(result + WIN_THE_GAME);
    }
}
