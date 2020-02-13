package racingcargame.controller;

import racingcargame.domain.MoveDecider;
import racingcargame.domain.RacingCars;
import racingcargame.domain.RepeatTimes;

import java.util.ArrayList;

public class RacingCarController {

    public String winner;

    public ArrayList<CarDto> run(String inputName, RepeatTimes inputRepeat) {
        final RacingCars racingCars = new RacingCars(inputName);
        final MoveDecider moveDecider = new MoveDecider();

        final ArrayList<CarDto> racingResult = processGame(inputRepeat, racingCars, moveDecider);
        winner = rankGame(racingCars);
        return racingResult;
    }

    private ArrayList<CarDto> processGame(RepeatTimes repeatTimes, RacingCars racingCars, MoveDecider moveDecider) {
        ArrayList<CarDto> racingResult = new ArrayList<>();
        for (int i = 0; i < repeatTimes.getRepeatTimes(); i++) {
            racingResult.add(racingCars.processOneRace(moveDecider));
        }
        return racingResult;
    }

    private String rankGame(RacingCars racingCars) {
        return racingCars.getWinner();
    }
}
