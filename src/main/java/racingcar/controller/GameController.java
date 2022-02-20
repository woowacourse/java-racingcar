package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.car.CarFactory;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerCarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final Game game;

    public GameController() {
        game = new Game(CarFactory.from(InputView.inputCarNames()), InputView.inputGameCount());
    }

    public void start() {
        OutputView.printGameResultTitle();

        for (int i = 0; i < game.getGameCount(); i++) {
            game.play(new RandomNumberGenerator());
            showResult();
        }
        showWinner();
    }

    public void showResult() {
        OutputView.printCarStatus(CarsDto.from(game.getCars()));
        OutputView.printBlankLine();
    }

    public void showWinner() {
        OutputView.printWinner(WinnerCarsDto.from(game.judgeWinner()));
    }
}
