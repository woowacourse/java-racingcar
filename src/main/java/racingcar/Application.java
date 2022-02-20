package racingcar;

import racingcar.utils.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        GameController gameController = new GameController(randomNumberGenerator);
        gameController.run();
    }
}
