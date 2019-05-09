package racingcar;

public class Main {
    public static void main(String[] args) {
        Racing racingGame = new Racing(InputView.inputCarNames(), InputView.inputNumberOfTimes());
        racingGame.run();
        Winner winner = racingGame.getWinner();
        OutputView.printWinners(winner);
    }
}
