package racingcar;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String carNames = inputView.inputCarNames();
        int tryCount = inputView.inputTryCount();
    }
}
