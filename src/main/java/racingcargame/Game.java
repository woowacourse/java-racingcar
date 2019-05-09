package racingcargame;

import racingcargame.model.Result;
import racingcargame.view.InputView;

import java.io.IOException;

public class Game {
    InputView inputView;
    Result result;

    public Game(){
        this.inputView = new InputView();
    }

    public void play() throws IOException {
        start();
    }

    void start() throws IOException {
        String names = inputView.readNames();
        result = new Result(names.split(","));
    }
}
