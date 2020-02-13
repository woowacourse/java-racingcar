package racingcargame.controller;

import racingcargame.domain.RacingCars;
import racingcargame.domain.Repeat;

import java.util.ArrayList;

public class RacingCarController {
    public String winner;

    public ArrayList<CarDto> run(String userInputName, Repeat userInputRepeat) {
        final RacingCars racingCars = new RacingCars(userInputName);
        final ArrayList<CarDto> carStatus = processGame(userInputRepeat, racingCars);
        winner = rankGame(racingCars);
        return carStatus;
    }

    private ArrayList<CarDto> processGame(Repeat repeat, RacingCars racingCars) {
        ArrayList<CarDto> carStatus = new ArrayList<>();
        for (int i = 0; i < repeat.getRepeat(); i++) {
            carStatus.add(racingCars.processOneRace());
        }
        return carStatus;
    }

    public String rankGame(RacingCars racingCars) {
        return racingCars.getWinner();
    }
}
