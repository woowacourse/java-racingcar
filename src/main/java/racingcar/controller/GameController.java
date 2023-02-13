package racingcar.controller;

import racingcar.domain.CarRepository;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomBasedMovement;
import racingcar.validator.NumberOfTryValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final RacingCarGame racingCarGame;
    private final InputView inputView;
    private final OutputView outputView;
    
    public GameController(InputView inputView, OutputView outputView, RacingCarGame racingCarGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarGame = racingCarGame;
    }

    public void run() {
        racingCarGame.addCars(readCarNames());
        runRacingGame(getParsedNumberOfTry());
        outputView.printWinners(racingCarGame.getWinners());
    }
    
    private String readCarNames() {
        return inputView.readCarNames();
    }
    
    private int getParsedNumberOfTry() {
        String numberOfTry = readNumberOfTry();
        NumberOfTryValidator.validate(numberOfTry);
        return Integer.parseInt(numberOfTry);
    }
    
    private String readNumberOfTry() {
        return inputView.readNumberOfTry();
    }

    private void runRacingGame(int numberOfTry) {
        while (numberOfTry-- > 0) {
            racingCarGame.race(new RandomBasedMovement());
            outputView.printCarsStatus(CarRepository.findAll());
        }
    }
}
