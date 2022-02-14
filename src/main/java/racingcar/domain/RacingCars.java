package racingcar.domain;

import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars() {
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void join(String inputCarNames) {
        Validator.validateHaveLastInputComma(inputCarNames);
        String[] validCarNames = inputCarNames.split(",");
        racingCars = new ArrayList<>();
        for (String validCarName : validCarNames) {
            racingCars.add(new RacingCar(validCarName));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public RacingCar getRacingCarMaxPosition() {
        return racingCars.stream().max(Comparator.comparingInt(RacingCar::getPosition)).get();
    }
}
