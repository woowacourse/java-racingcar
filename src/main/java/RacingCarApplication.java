import service.RacingGameService;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {
    private RacingGameService racingGameService;
    private RacingGameResultService racingGameResultService;

    RacingCarApplication() {
        racingGameService = new RacingGameService();
        racingGameResultService = new RacingGameService();
    }

    private static void run() {
        racingGameService.run();
        racingGameResultService.run();
    }

    public static void main(String[] args) {
        racingGameService = new RacingGameService(InputView.inputCarsNames());

        int lapCount = InputView.inputLapCount();
        OutputView.printResultMessage();
        for (int i = 0; i < lapCount; i++) {
            OutputView.printLapReseult(racingGameService.run());
        }
        OutputView.printWinners(racingGameService.getWinners());
    }
}
