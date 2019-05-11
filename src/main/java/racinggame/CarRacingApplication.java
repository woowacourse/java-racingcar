package racinggame;

import racinggame.controller.CarRaceReady;
import racinggame.controller.CarRaceResult;
import racinggame.controller.CarRacing;

public class CarRacingApplication {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(CarRaceReady.getCars(), CarRaceReady.getTotalTrial());

        CarRaceResult carRaceResult = new CarRaceResult(carRacing.raceStart());

        carRaceResult.showCarRaceResult(carRacing.getTotalTrial());
    }


}
