package domain;

import domain.validator.GameTrialCountValidator;

public class GameTrialCount {

    int gameTrial;

    public GameTrialCount(String gameTrial) {
        validate(gameTrial);
        this.gameTrial = Integer.parseInt(gameTrial);
    }

    public boolean isGreaterThan(int otherCount) {
        return gameTrial > otherCount;
    }

    public void reduce() {
        gameTrial--;
    }

    private static void validate(String gameTrial) {
        GameTrialCountValidator.validateTrialCount(gameTrial);
    }
}