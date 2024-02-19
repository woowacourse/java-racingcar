package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class RandomNumberOfPower implements NumberOfPower {

    @Override
    public List<Integer> generateNumbersOfPower(int size) {
        List<Integer> numbersOfPowers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbersOfPowers.add(decideNumberOfPower());
        }
        return Collections.unmodifiableList(numbersOfPowers);
    }

    private int decideNumberOfPower() {
        return RandomNumberGenerator.generate(MIN_NUMBER_OF_POWER, MAX_NUMBER_OF_POWER);
    }
}
