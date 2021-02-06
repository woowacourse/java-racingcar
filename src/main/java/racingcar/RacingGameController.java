package racingcar;

public class RacingGameController {

    private final InputView inputView;
    private Cars cars;
    private Integer turns;

    public RacingGameController() {
        inputView = new InputView();
    }

    public void startGame() {
        setUpRace();
        startRace();
        showResult();
    }

    private void setUpRace() {
        cars = Cars.from(inputView.getInputCarsName());
        turns = inputView.getInputTurns();
    }

    private void startRace() {
        OutputView.printResultPrefix();
        OutputView.printCarsBeforeRace(cars.getCars());

        race();
    }

    private void race() {
        for (int i = 0; i < turns; i++) {
            cars.driveAll();
            OutputView.printCarsAfterRace(cars.getCars());
        }
    }

    private void showResult() {
        OutputView.printWinners(cars.getWinners());
    }
}
