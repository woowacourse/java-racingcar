import model.LapRecorder;
import model.Winners;
import service.RacingGameService;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) throws CloneNotSupportedException {
        RacingGameService racingGameService = setRacingGame();
        LapRecorder lapRecorder = racingGameService.run();
        Winners winners = racingGameService.getWinners();
        OutputView.printGameResult(lapRecorder);
        OutputView.printWinners(winners);
    }

    private static RacingGameService setRacingGame() {
        try {
            String inputCarNames = InputView.inputCarsNames();
            String lapCount = InputView.inputLapCount();
            return new RacingGameService(inputCarNames, lapCount);
        } catch (IllegalArgumentException e) {
            return setRacingGame();
        }
    }
}
