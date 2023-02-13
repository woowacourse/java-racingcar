package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingcarService;
import racingcar.ui.OutputView;

public class RacingcarController {

    private final RacingcarService racingcarService;
    private final OutputView outputView;

    public RacingcarController(OutputView outputView, RacingcarService racingcarService) {
        this.racingcarService = racingcarService;
        this.outputView = outputView;
    }

    public void run(int tryCount) {
        playGame(tryCount);
        findWinners();
    }

    private void playGame(int tryCount) {
        outputView.playRound();
        for (int i = 0; i < tryCount; i++) {
            List<Car> movedCars = racingcarService.move();
            outputView.result(movedCars);
        }
    }

    private void findWinners() {
        List<Car> winners = racingcarService.findWinners();
        outputView.winner(winners);
    }
}
