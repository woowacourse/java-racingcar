package racinggame.race;

import racinggame.race.car.Cars;
import racinggame.race.car.engine.RealEngine;
import racinggame.race.view.InputView;
import racinggame.race.view.OutputView;
import racinggame.race.view.dto.RacingReqDTO;
import racinggame.race.view.dto.RacingResBundleDTO;

public class Race {

    public void run() {
        RacingReqDTO reqDTO = InputView.inputRequest();
        Cars cars = reqDTO.toCars();

        OutputView.showReady(RacingResBundleDTO.from(cars));
        for (int i = 0; i < reqDTO.getCount(); i++) {
            cars.move(new RealEngine());
            OutputView.showCars(RacingResBundleDTO.from(cars));
        }
        OutputView.showWinners(cars.getWinner());
    }

}
