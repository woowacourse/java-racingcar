package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.car.CarFactory;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.dto.CarDto;
import racingcar.dto.WinnerCarDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

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
        List<CarDto> carDtos = game.getCarDto();

        for (CarDto carDto : carDtos) {
            OutputView.printLineString(carDto);
        }
        OutputView.printBlankLine();
    }

    public void showWinner() {
        List<WinnerCarDto> winnerCarDtos = game.getCarWinnerDto();
        OutputView.printWinner(winnerCarDtos);
    }
}
