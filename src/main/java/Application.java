import controller.RacingGame;
import utils.Randoms;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new Randoms());
        racingGame.run();
    }
}
