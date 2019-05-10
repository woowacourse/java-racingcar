import model.LapRepository;
import model.Winners;
import service.RacingGameService;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) throws CloneNotSupportedException{
        RacingGameService racingGameService = racingGameServiceGeneration();
        LapRepository lapRepository = racingGameService.run();
        Winners winners = racingGameService.getWinners();
        OutputView.printGameResult(lapRepository);
        OutputView.printWinners(winners);
    }

    private static RacingGameService racingGameServiceGeneration() {
        try {
            String carNames = InputView.inputCarsNames();
            String lapCount = InputView.inputLapCount();
            return new RacingGameService(carNames, lapCount);
        } catch (IllegalArgumentException e) {
            return racingGameServiceGeneration();
        }
    }
}
