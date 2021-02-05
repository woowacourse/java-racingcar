package racingcar;

public class RacingGameController {

    private final InputView inputView;

    public RacingGameController() {
        inputView = new InputView();
    }

    public void startRace() {
        String carsName = inputView.getInputCarsName();
        Cars.makeCar(carsName);
    }
}
