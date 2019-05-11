import model.LapRecord;
import model.Winners;
import service.RacingGameService;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingGameService racingGameService = racingGameServiceGeneration();
        LapRecord lapRecord = racingGameService.run();
        Winners winners = racingGameService.getWinners();
        OutputView.printGameResult(lapRecord);
        OutputView.printWinners(winners);
    }

    private static RacingGameService racingGameServiceGeneration() {
        try {
            String carNames = InputView.inputCarsNames();
            String lapCount = InputView.inputLapCount();
            return new RacingGameService(carNames, lapCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return racingGameServiceGeneration();
        }
    }
}
