package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingcarService;
import racingcar.ui.OutputView;

public class RacingcarController {

    private final RacingcarService racingcarService;

    public RacingcarController() {
        this.racingcarService = new RacingcarService();
    }

    public void run(String carNames, int tryCount) {
        List<Car> cars = racingcarService.getCar(carNames);

        playRace(tryCount, cars);
        int winnerPosition = findWinnerPosition(cars);
        List<Car> winners = findWinners(cars, winnerPosition);

        printWinners(winners);
    }

    private int findWinnerPosition(List<Car> cars) {
        return racingcarService.findPosition(cars);
    }

    private List<Car> findWinners(List<Car> cars, int winnerPosition) {
        return racingcarService.findWinner(cars, winnerPosition);
    }

    private void printWinners(List<Car> cars) {
        OutputView.winner(cars);
    }

    private void playRace(int tryCount, List<Car> cars) {
        OutputView.playRound();
        for (int i = 0; i < tryCount; i++) {
            racingcarService.move(cars);
            OutputView.result(cars);
        }
    }
}
