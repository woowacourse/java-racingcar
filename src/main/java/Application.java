import controller.RacingGameManager;
import utils.Engine;
import utils.RandomMovingEngine;

public class Application {
    public static void main(String[] args) {
        Engine engine = new RandomMovingEngine();
        RacingGameManager manager = new RacingGameManager(engine);

        manager.run();
    }
}
