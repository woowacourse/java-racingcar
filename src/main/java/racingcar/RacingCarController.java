package racingcar;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int tryCount = inputView.inputTryCount();
    }
}
