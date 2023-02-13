package domain;

import domain.validator.GameTrialCountValidator;

public class GameTrialCount {

    private int gameTrialCount;

    public GameTrialCount(String gameTrial) {
        validate(gameTrial);
        this.gameTrialCount = Integer.parseInt(gameTrial);
    }

    public boolean isGreaterThan(int otherCount) {
        return gameTrialCount > otherCount;
    }

    public void reduce() {
        gameTrialCount--;
    }

    private static void validate(String gameTrial) {
        GameTrialCountValidator.validateTrialCount(gameTrial);
    }
}