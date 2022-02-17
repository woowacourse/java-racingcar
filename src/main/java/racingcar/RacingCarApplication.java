package racingcar;

import racingcar.domain.RacingGame;
import racingcar.io.Input;
import racingcar.io.Output;

public class RacingCarApplication {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        startGame(input, output);
    }

    private static void startGame(Input input, Output output) {
        RacingGame racingGame = new RacingGame(input.inputCarNames(), input.inputTrials());
        while (!racingGame.isEnd()) {
            racingGame.race();
            output.printCurrentPosition(racingGame.getCars());
        }
        output.printWinner(racingGame.getWinners());
    }
}
