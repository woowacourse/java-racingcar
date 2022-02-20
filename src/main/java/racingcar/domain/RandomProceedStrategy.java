package racingcar.domain;

import racingcar.utils.RandomIntegerGenerator;

public class RandomProceedStrategy implements ProceedStrategy {
    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int PROCEED_FlAG_NUMBER = 4;

    @Override
    public boolean canProceed() {
        return RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER) > PROCEED_FlAG_NUMBER;
    }
}
