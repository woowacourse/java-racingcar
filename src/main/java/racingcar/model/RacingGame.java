package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String INITIAL_TRIAL_COUNT = "0";
    private static final String COMMA = ",";

    private final Cars cars;
    private final TrialNum trialNum;
    private final TrialNum trialCnt;
    private final NumberGenerator randomNumber = new RandomNumberGenerator();

    public RacingGame(String namesInput, String trialNumInput) {
        this.cars = createCars(namesInput);
        this.trialNum = createTrialNum(trialNumInput);
        this.trialCnt = new TrialNum(INITIAL_TRIAL_COUNT);
    }

    public boolean isEnd() {
        return trialNum.equals(trialCnt);
    }

    public void race() {
        cars.moveAll(randomNumber);
        trialCnt.increase();
    }

    public WinnerCars findWinner() {
        int maxPosition = cars.findMaxPosition();
        return new WinnerCars(cars.findWinnerName(maxPosition), maxPosition);
    }

    private Cars createCars(String namesInput) {
        List<Name> carNames = createName(namesInput);
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private List<Name> createName(String carNames) {
        return Arrays.stream(carNames.split(COMMA))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private TrialNum createTrialNum(String trialNum) {
        return new TrialNum(trialNum);
    }

    public Cars getRacingCars() {
        return cars;
    }
}
