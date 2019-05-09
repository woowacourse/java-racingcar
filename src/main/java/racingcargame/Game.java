package racingcargame;

import racingcargame.view.InputView;

import java.io.IOException;

public class Game {
    InputView inputView;

    public Game(){
        this.inputView = new InputView();
    }

    public void play() throws IOException {
        start();
    }

    void start() throws IOException {
        String names = inputView.readNames();
    }
}
