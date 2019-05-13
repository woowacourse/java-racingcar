/*
 * @(#)Rule.java
 *
 * v 2.0.0
 *
 * 2019.05.13
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.domain;

/**
 * 랜덤한 수를 생성하고 이동 가능 여부를 판단해주는 클래스
 *
 * @author kwonmc
 * @version 2.0.0
 */
public class Rule {
    private static final int RAND_INT_UPPER_BOUND = 10;
    private static final int CRITERIA_OF_GO_STOP = 4;

    private final int random = (int) (Math.random() * RAND_INT_UPPER_BOUND);

    public boolean goOrStop() {
        return this.random >= CRITERIA_OF_GO_STOP;
    }
}
