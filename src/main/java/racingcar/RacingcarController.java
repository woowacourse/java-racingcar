package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class RacingcarController {

    private final RacingcarService racingcarService;

    public RacingcarController() {
        this.racingcarService = new RacingcarService();
    }

    public void run(String carNames, int tryCount) {
        Cars cars = racingcarService.makeCars(carNames);

        OutputView.playRound();
        for (int i = 0; i < tryCount; i++) {
            racingcarService.move(cars);
            OutputView.result(cars);
        }

        List<Car> winners = racingcarService.findWinner(cars);
        OutputView.winner(winners);
    }
}
