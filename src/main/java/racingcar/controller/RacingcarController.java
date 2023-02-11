package racingcar.controller;

import java.util.List;
import racingcar.service.RacingcarService;
import racingcar.ui.OutputView;

public class RacingcarController {

    private final RacingcarService racingcarService;

    public RacingcarController(RacingcarService racingcarService) {
        this.racingcarService = racingcarService;
    }

    public void run(int tryCount) {
        playGame(tryCount);
        findWinners();
    }

    private void playGame(int tryCount) {
        OutputView.playRound();
        for (int i = 0; i < tryCount; i++) {
            List<String> movedCars = racingcarService.move();
            OutputView.result(movedCars);
        }
    }

    private void findWinners() {
        List<String> winners = racingcarService.findWinners();
        OutputView.winner(winners);
    }
}
