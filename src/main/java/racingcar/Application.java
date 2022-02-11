package racingcar;

public class Application {

    public static void main(String[] args){
        String carNames = InputView.askCarName();
        String tryCount = InputView.askTryCount();
        RacingCars racingCars = new RacingCars();
        racingCars.join(carNames);
        RacingGame racingGame = new RacingGame();
        //RacingGame racingGame = new RacingGame(carNames, tryCount);
        racingGame.playGame(racingCars, Integer.parseInt(tryCount));
        String winnersName = racingGame.getWinnersName(racingGame.getWinners(racingCars));

    }
}
