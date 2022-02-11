package racingcar;

public class Application {

    public static void main(String[] args){
        String carNames = InputView.askCarName();
        String tryCount = InputView.askTryCount();
        RacingGame racingGame = new RacingGame(carNames, tryCount);


    }
}
