package domain;

import utils.RandomUtil;

public class RandomNumberStrategy implements GameMovingStrategy {

    @Override
    public int getMovingNum() {
        return RandomUtil.randomNumber();
    }
}
