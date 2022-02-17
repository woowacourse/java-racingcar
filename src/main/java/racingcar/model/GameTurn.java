package racingcar.model;

public class GameTurn {
    public static final int MIN_GAME_TURN = 1;
    private static final String GAME_TURN_NUMBER_ERROR_MESSAGE = "[Error] 양수를 입력하세요.";

    private int gameTurn;

    public GameTurn(int gameTurn) {
        checkGameTurnNumber(gameTurn);
        this.gameTurn = gameTurn;
    }

    private void checkGameTurnNumber(int gameTurn) {
        if (gameTurn < MIN_GAME_TURN) {
            throw new IllegalArgumentException(GAME_TURN_NUMBER_ERROR_MESSAGE);
        }
    }

    public boolean isPositive() {
        return gameTurn > 0;
    }

    public void removeTurn() {
        gameTurn--;
    }
}
