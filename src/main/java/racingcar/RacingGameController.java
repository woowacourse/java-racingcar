package racingcar;

public class RacingGameController {

    private final InputView inputView;
    private Cars cars;
    private int turns;

    public RacingGameController() {
        inputView = new InputView();
    }

    public void startGame() {
        setUpRace();
        startRace();
        showResult();
    }

    private void setUpRace() {
        cars = Cars.of(inputView.getInputCarsName(), new RandomNumberGeneratingStrategy());
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
            OutputView.printCars(cars.getCars());
        }
    }

    private void showResult() {
        OutputView.printWinners(cars.getWinners());
    }
}
