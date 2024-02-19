package racingcar.domain;

import java.util.List;

public interface NumberOfPower {

    int MIN_NUMBER_OF_POWER = 0;
    int MAX_NUMBER_OF_POWER = 9;

    List<Integer> generateNumbersOfPower(int size);
}
