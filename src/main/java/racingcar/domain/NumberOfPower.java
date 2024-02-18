package racingcar.domain;

import java.util.List;

public abstract class NumberOfPower {

    protected static final int MIN_NUMBER_OF_POWER = 0;
    protected static final int MAX_NUMBER_OF_POWER = 9;

    protected abstract List<Integer> generateNumbersOfPower(int size);
}
