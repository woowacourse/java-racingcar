package racinggame;

import racinggame.controller.CarRaceReady;
import racinggame.controller.CarRaceResult;
import racinggame.controller.CarRacing;
import racinggame.controller.CarRaceRunCondition;
import racinggame.util.OutputView;

public class CarRacingApplication {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(CarRaceReady.getCars(), CarRaceReady.getTotalTrial());

        CarRaceResult carRaceResult = carRacing.raceStart(new CarRaceRunCondition());

        OutputView.showCarRaceResult(carRaceResult);
    }


}
