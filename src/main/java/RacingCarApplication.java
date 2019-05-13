import model.GameBoard;
import service.RacingGameService;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        GameBoard gameBoard = requestGame();
        OutputView.printGameResult(gameBoard.getLapRecord());
        OutputView.printWinners(gameBoard.getWinners());
    }

    private static GameBoard requestGame() {
        try {
            String carNames = InputView.inputCarsNames();
            String lapCount = InputView.inputLapCount();
            return RacingGameService.request(carNames, lapCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestGame();
        }
    }
}
