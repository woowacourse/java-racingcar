package racingcar.domain;

public class GameRepository {

    private static Game game;

    public void initGame(Game newGame) {
        game = newGame;
    }

    public Game getGame() {
        return game;
    }
}
