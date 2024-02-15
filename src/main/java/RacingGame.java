public class RacingGame {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.readCarNames());
        int count = InputView.readRoundNumber();
        OutputView.showRoundStart();
        for (int round = 1; round <= count; round++) {
            cars.tryMove();
            OutputView.showRoundResult(cars.getRoundResult());
        }
        OutputView.showWinners(cars.getWinnersName());
    }
}
