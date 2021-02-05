package racingcar;

public class RacingGameController {

    private final InputView inputView;
    private Cars cars;
    private Integer turns;

    public RacingGameController() {
        inputView = new InputView();
    }

    public void race() {
        setUpRace();
        startRace();
    }

    private void startRace() {
        OutputView.printResultPrefix();
        for (int i = 0; i < turns; i++) {
            cars.driveAll();
        }
    }

    private void setUpRace() {
        cars = Cars.makeCar(inputView.getInputCarsName());
        turns = inputView.getInputTurns();
    }
}
