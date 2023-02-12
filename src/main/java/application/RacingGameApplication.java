package application;

import domain.Cars;
import domain.Name;
import domain.RacingGame;
import domain.TryCount;
import dto.response.CarStatusDto;
import dto.response.WinnersNameDto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RacingGameApplication(InputView inputView, OutputView outputView, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGame = racingGame;
    }

    public void run() {
        List<Name> names = inputView.sendCarsName();
        TryCount tryCount = inputView.sendTryCount();
        Cars cars = Cars.of(names);

        play(tryCount, cars);
        printWinners(cars);
    }

    private void play(TryCount tryCount, Cars cars) {
        List<List<CarStatusDto>> result = racingGame.play(cars, tryCount);
        outputView.printGameResult(result);
    }

    private void printWinners(Cars cars) {
        WinnersNameDto winners = racingGame.findWinners(cars);
        outputView.printWinners(winners);
    }

}
