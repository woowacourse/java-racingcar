package racingcar;

import java.util.List;

public class RacingcarController {

    private final CarFactory carFactory;
    private final RacingcarService racingcarService;

    public RacingcarController() {
        this.carFactory = new CarFactory();
        this.racingcarService = new RacingcarService();
    }

    public void run(String carNames, int tryCount) {
        List<Car> cars = carFactory.makeCars(carNames);

        OutputView.playRound();
        for (int i = 0; i < tryCount; i++) {
            racingcarService.move(cars);
            OutputView.result(cars);
        }

        List<Car> winners = racingcarService.findWinner(cars);
        OutputView.winner(winners);
    }
}
