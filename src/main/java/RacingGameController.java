public class RacingGameController {


    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = inputView.readCars();
        int count = inputView.readCount();
        RacingGame racingGame = RacingGame.of(count, cars, new RandomMovementGenerator(new RandomNumberGenerator()));
        outputView.showStatusMessage();
        play(cars, count);
        Winners winners = Winners.from(cars);
        outputView.showResult(winners);
    }

    public void play(Cars cars, int count) {
        for (int i = 0; i < count; i++) {
            cars.move(new RandomMovementGenerator(new RandomNumberGenerator()));
            outputView.showStatus(cars);
        }
    }
}
