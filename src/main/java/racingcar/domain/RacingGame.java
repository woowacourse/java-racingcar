package racingcar.domain;

import racingcar.util.BoundedRandomNumberGenerator;

public class RacingGame {
    private static final int MAX_BOUND = 9;
    private static final int MIN_BOUND = 0;

    private ParticipatedCars participatedCars;
    private TrialCount trialCount;

    private RacingGame(ParticipatedCars participatedCars, TrialCount trialCount) {
        this.participatedCars = participatedCars;
        this.trialCount = trialCount;
    }

    public static RacingGame of(String carNamesLine, String trialCountLine) {
        return new RacingGame(ParticipatedCars.from(carNamesLine), TrialCount.from(trialCountLine));
    }

    public void raceOnce() {
        participatedCars.tryToMoveBy(new BoundedRandomNumberGenerator(MAX_BOUND, MIN_BOUND));
        trialCount.consume();
    }

    public boolean canRaceMore() {
        return !trialCount.isEmpty();
    }

    public ParticipatedCars getParticipatedCars() {
        return participatedCars;
    }
}
