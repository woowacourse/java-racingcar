package racingGame.domain;

import racingGame.controller.Input;
import racingGame.controller.Output;
import racingGame.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String... args){
        Input input = new Input();
        Output output = new Output();
        RacingGame.play(input, output);


    }
}
