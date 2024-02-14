package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.dto.RoundResult;
import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingcarService racingcarService = new RacingcarService();

    public void run() {
        List<Car> cars = inputView.readCarNames().stream()
                .map(Car::new)
                .toList();
        Round round = new Round(inputView.readTryCount());

        List<RoundResult> roundResults = new ArrayList<>();
        while (round.isRemain()) {
            RoundResult roundResult = racingcarService.processRound(cars);
            roundResults.add(roundResult);
            round.decreaseCount();
        }
        outputView.printRoundResults(roundResults);
    }
}
