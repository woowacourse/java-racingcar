import racingCar.Game;
import racingCar.view.InputView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int raceCount = InputView.getRaceCount();
        Game game = new Game(carNames, raceCount);
        game.run();
    }
}
