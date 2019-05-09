import service.RacingGameService;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingGameService racingGameService = new RacingGameService(InputView.inputCarsNames());
        int lapCount = InputView.inputLapCount();
        OutputView.printResultMessage();
        for (int i = 0; i < lapCount; i++) {
            OutputView.printLapReseult(racingGameService.run());
        }
        OutputView.printWinners(racingGameService.getWinners());
    }
}
