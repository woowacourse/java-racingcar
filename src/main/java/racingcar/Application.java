package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.track.Track;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = RacingCarContext.racingController();
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
