package com.woowacourse.javaracingcar.domain;

import com.woowacourse.javaracingcar.interfaces.RacingcarGameRule;

public class RacingcarGameRuleImpl implements RacingcarGameRule {
    private static final int ARG_MIN = 0;
    private static final int ARG_MAX = 10;
    private static final int MOVE_BOUND = 4;
    private static final int POSITION_TO_MOVE = 1;
    private static final int POSITION_TO_STOP = 0;

    @Override
    public int calculatePositionToMove(int number) {
        if (ARG_MIN > number || number > ARG_MAX) {
            throw new IllegalArgumentException("Invalid number for calculating position to move: " + number);
        }

        if (number >= MOVE_BOUND) {
            return POSITION_TO_MOVE;
        }

        return POSITION_TO_STOP;
    }
}
