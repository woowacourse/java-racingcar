package racingCar.domain.classForTest;

import racingCar.domain.Decider;
import racingCar.domain.DeciderFactory;

public class TestDeciderFactory implements DeciderFactory {
    private static final int FIVE = 5;

    @Override
    public Decider create() {
        return new Decider(FIVE);
    }
}
