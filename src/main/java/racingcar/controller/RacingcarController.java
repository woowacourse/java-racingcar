package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.service.RacingcarService;
import racingcar.view.InputView;

public class RacingcarController {
    private final InputView inputView = new InputView();
    private final RacingcarService racingcarService = new RacingcarService();

    public void run() {
        List<Car> cars = inputView.readCarNames().stream()
                .map(Car::new)
                .toList();
        Round round = new Round(inputView.readTryCount());

        while (round.isRemain()) {
            racingcarService.processRound(cars);
            round.decreaseCount();
        }
    }
}
