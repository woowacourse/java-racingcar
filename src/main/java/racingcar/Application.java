package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.car.strategy.RandomMovingStrategy;
import racingcar.model.track.Track;

public class Application {
    public static void main(String[] args) {
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        RacingController racingController = RacingCarContext.getRacingControllerInstance(randomMovingStrategy);
        try {
            Track track = racingController.generateRacingTrack();

            racingController.startRace(track);
            racingController.concludeWinner(track);
        } catch (IllegalArgumentException illegalArgumentException) {
            racingController.terminatedByException(illegalArgumentException.getMessage());
        } catch (NullPointerException nullPointerException) {
            racingController.terminatedByException(nullPointerException.getMessage());
        } catch (Exception exception) {
            racingController.terminated();
        }
    }
}
