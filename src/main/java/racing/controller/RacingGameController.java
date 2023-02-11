package racing.controller;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<String> names = inputView.inputNames();
        Cars cars = new Cars(names.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
        int tryCount = inputView.inputTryCount();

        RacingGame game = new RacingGame(tryCount, cars);
        while (!game.isEnd()) {
            game.playOneRound();
            outputView.printRacing(cars);
        }
        List<String> winnerNames = game.getWinners();
        outputView.printWinners(winnerNames);
    }
}
