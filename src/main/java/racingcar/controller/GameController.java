package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.dto.CarDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private static final String WINNER_NAME_DELIMITER = ", ";

    private final Game game;

    public GameController() {
        game = new Game(CarFactory.of(InputView.inputCarNames()), InputView.inputGameCount());
    }

    public void start() {
        OutputView.printGameResultTitle();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < game.getGameCount(); i++) {
            game.play(numberGenerator);
            showResult();
        }

        showWinner(game.judgeWinner());
    }

    public void showResult() {
        List<CarDto> carDtos = game.getCarDto();

        for (CarDto carDto : carDtos) {
            OutputView.printLineString(carDto);
        }
        OutputView.printBlankLine();
    }

    public void showWinner(List<Car> winnerCars) {
        String winnerNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));

        OutputView.printWinner(winnerNames);
    }
}
