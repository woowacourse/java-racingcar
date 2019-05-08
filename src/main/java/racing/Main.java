package racing;

public class Main {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        racingGame.inputCarNames();
        racingGame.inputTotalTimes();
        racingGame.printAllTimeResult();
        racingGame.printAllWinners();
    }
}
