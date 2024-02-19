package racingcar.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomOilGenerator extends OilGenerator {

    @Override
    protected int generate() {
        return Randoms.pickNumberInRange(MIN_OIL_AMOUNT, MAX_OIL_AMOUNT);
    }
}
