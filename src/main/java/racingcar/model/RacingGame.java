package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final TrialNum trialNum;

    public RacingGame(String namesInput, String trialNumInput) {
        this.cars = createCars(namesInput);
        this.trialNum = createTrialNum(trialNumInput);
    }

    private Cars createCars(String namesInput) {
        List<Name> carNames = createName(namesInput);
        return new Cars (carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private List<Name> createName(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private TrialNum createTrialNum(String trialNum) {
        return new TrialNum(trialNum);
    }
}
