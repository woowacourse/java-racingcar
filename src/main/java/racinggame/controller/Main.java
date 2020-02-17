package racinggame.controller;

import racinggame.domain.Input;
import racinggame.domain.RacingGame;

public class Main {
    public static void main(String... args) {
        Input input = new Input();
        RacingGame.play(input);
    }
}

