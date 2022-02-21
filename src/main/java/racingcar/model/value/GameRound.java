package racingcar.model.value;

import static racingcar.message.ErrorMessages.*;

import java.util.Objects;

public class GameRound {
    private final int totalRound;
    private int completedRound;

    private GameRound(int totalRound) {
        this.totalRound = totalRound;
        completedRound = 0;
        validate();
    }

    public static GameRound fromString(String countString) {
        return new GameRound(convertStringToInt(countString));
    }

    public void proceed() {
        completedRound++;
    }

    public boolean continuable() {
        return totalRound > completedRound;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GameRound gameRound1 = (GameRound) obj;
        return totalRound == gameRound1.totalRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRound);
    }

    private static int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_CNT_NOT_NUMBER);
        }
    }

    private void validate() {
        if (totalRound < 0) {
            throw new IllegalArgumentException(TRY_CNT_NOT_POSITIVE);
        }
    }
}
