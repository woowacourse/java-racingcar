package racingGame;

import java.util.List;

public class Main {
    public static void main(String... args){
        Input input = new Input();
        List<String> list = RacingGame.play(input);
        Output.makeWinnerNames(list);

    }
}
