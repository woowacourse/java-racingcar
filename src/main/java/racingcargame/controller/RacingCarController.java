package racingcargame.controller;

import racingcargame.domain.RacingCars;
import racingcargame.domain.Repeat;

import java.util.ArrayList;

public class RacingCarController {
    public String winner;

    public ArrayList<CarDto> run(String inputName, Repeat inputRepeat) {
        final RacingCars racingCars = new RacingCars(inputName);
        final ArrayList<CarDto> racingResult = processGame(inputRepeat, racingCars);
        winner = rankGame(racingCars);
        return racingResult;
    }

    private ArrayList<CarDto> processGame(Repeat repeat, RacingCars racingCars) {
        ArrayList<CarDto> racingResult = new ArrayList<>();
        for (int i = 0; i < repeat.getRepeat(); i++) {
            racingResult.add(racingCars.processOneRace());
        }
        return racingResult;
    }

    public String rankGame(RacingCars racingCars) {
        return racingCars.getWinner();
    }
}
