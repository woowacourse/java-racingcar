package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarFactory;
import racingcar.service.RacingcarService;
import racingcar.ui.OutputView;

public class RacingcarController {

    private final CarFactory carFactory;
    private final RacingcarService racingcarService;

    public RacingcarController() {
        this.carFactory = new CarFactory();
        this.racingcarService = new RacingcarService();
    }

    public void run(String carNames, int tryCount) {
        List<Car> cars = getCars(carNames);

        playRace(tryCount, cars);

        printWinners(cars);
    }

    private void printWinners(List<Car> cars) {
        List<Car> winners = racingcarService.findWinner(cars);
        OutputView.winner(winners);
    }

    private void playRace(int tryCount, List<Car> cars) {
        OutputView.playRound();
        for (int i = 0; i < tryCount; i++) {
            racingcarService.move(cars);
            OutputView.result(cars);
        }
    }

    private List<Car> getCars(String carNames) {
        return carFactory.makeCars(carNames);
    }
}
