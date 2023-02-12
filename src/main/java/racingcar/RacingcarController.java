package racingcar;

import java.util.List;

public class RacingcarController {

    private final RacingcarService racingcarService;

    public RacingcarController() {
        this.racingcarService = new RacingcarService();
    }

    public void run(String carNames, int tryCount) {
        List<Car> cars = racingcarService.makeCars(carNames);

        OutputView.playRound();
        for (int i = 0; i < tryCount; i++) {
            racingcarService.move(cars);
            OutputView.result(cars);
        }

        int maxPosition = racingcarService.findMaxPosition(cars);
        List<Car> winners = racingcarService.findWinner(cars, maxPosition);
        OutputView.winner(winners);
    }
}
