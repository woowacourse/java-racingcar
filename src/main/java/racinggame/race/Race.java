package racinggame.race;

import racinggame.race.car.Cars;
import racinggame.race.car.engine.RealEngine;
import racinggame.race.view.InputView;
import racinggame.race.view.OutputView;
import racinggame.race.view.dto.RacingRequestDTO;
import racinggame.race.view.dto.RacingResponseDTO;

public class Race {

    public void run() {
        RacingRequestDTO reqDTO = InputView.inputRequest();
        Cars cars = reqDTO.toCars(RealEngine.getInstance());

        OutputView.showReady(RacingResponseDTO.listFrom(cars));
        for (int i = 0; i < reqDTO.getCount(); i++) {
            cars.move();
            OutputView.showCars(RacingResponseDTO.listFrom(cars));
        }
        OutputView.showWinners(cars.getWinner());
    }

}
