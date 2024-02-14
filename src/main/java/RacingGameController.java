public class RacingGameController {


    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.readCars();
        Cars cars = Cars.fromEmpty();
        RacingGame racingGame = RacingGame.of(3, cars);
        racingGame.play();
        Winners winners = Winners.from(cars);

    }
}
