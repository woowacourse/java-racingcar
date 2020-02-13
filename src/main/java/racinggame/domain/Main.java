package racinggame.domain;

import racinggame.controller.Input;
import racinggame.controller.Output;

public class Main {
    public static void main(String... args){
        Input input = new Input();
        Output output = new Output();
        RacingGame.play(input, output);


    }
}
