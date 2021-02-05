package racingcar;

public class RacingGameController {

    private final InputView inputView;

    public RacingGameController() {
        inputView = new InputView();
    }

    public void startRace() {
        Cars cars = Cars.makeCar(inputView.getInputCarsName());
        Integer turns = inputView.getInputTurns();
    }
}
