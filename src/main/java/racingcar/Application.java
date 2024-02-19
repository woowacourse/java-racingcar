package racingcar;

import racingcar.controller.RacingCarGameMachine;
import racingcar.util.ConsoleReader;

public class Application {
    public static void main(String[] args) {
        final var consoleReader = new ConsoleReader();

        final var racingGame = new RacingCarGameMachine(consoleReader);
        racingGame.run();
    }
}
