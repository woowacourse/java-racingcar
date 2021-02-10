package racingcar;


public class Application {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int racingTryTime = InputView.getRacingTryTime();

        RacingGame racingGame = new RacingGame(carNames, racingTryTime);
        while(!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
