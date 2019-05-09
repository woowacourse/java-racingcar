package racing.game;

import racing.view.InputView;

public class Game {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        Rounds.start(InputView.getCars(), InputView.getRoundNumber());
    }
}
