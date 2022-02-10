package racingcar;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingCars racingCars = new RacingCars(inputView.inputCarNames());
        int tryCount = inputView.inputTryCount();

        RacingGame game = new RacingGame(racingCars, tryCount);
        outputView.printGameResultTitle();
        while (!game.isEnd()) {
            game.race();
            outputView.printCarsPosition(racingCars.getRacingCars());
        }
        outputView.printWinnerNames(game.winnerNames());
    }
}
