package racingcar.domain;

public class GameStatus {
    private final String status;

    public GameStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}
