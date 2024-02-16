package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomOilGenerator {

    private static final int MIN_OIL_AMOUNT = 0;
    private static final int MAX_OIL_AMOUNT = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(MIN_OIL_AMOUNT, MAX_OIL_AMOUNT);
    }
}
