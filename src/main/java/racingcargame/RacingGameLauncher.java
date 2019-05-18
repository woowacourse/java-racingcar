package racingcargame;

import racingcargame.controller.RacingGame;
import racingcargame.model.Car;
import racingcargame.model.Judge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameLauncher {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        RacingGame game = new RacingGame();
        game.play();
    }

}
