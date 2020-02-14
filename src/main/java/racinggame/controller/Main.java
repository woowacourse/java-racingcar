package racinggame.controller;

import racinggame.domain.Input;
import racinggame.domain.Output;
import racinggame.domain.RacingGame;

public class Main {
    public static void main(String... args) {
        Input input = new Input();
        Output output = new Output();
        RacingGame.play(input, output);
    }
}

