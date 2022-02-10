package racingcar;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        RacingCars racingCars = new RacingCars(inputView.inputCarNames());
        int tryCount = inputView.inputTryCount();

        RacingGame game = new RacingGame(racingCars, tryCount);
        game.race();
    }
}
