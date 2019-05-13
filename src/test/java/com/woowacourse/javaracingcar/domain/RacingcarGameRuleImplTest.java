package com.woowacourse.javaracingcar.domain;

import com.woowacourse.javaracingcar.interfaces.RacingcarGameRule;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarGameRuleImplTest {

    @Test
    void testCalculatingPositionToMove() {
        int[] numsToGenerate = new int[] {1, 3, 4, 5};
        RacingcarGameRule rule = new RacingcarGameRuleImpl(new TestNumberGenerator(numsToGenerate));
        assertThat(rule.getPositionToMove()).isEqualTo(0);
        assertThat(rule.getPositionToMove()).isEqualTo(0);
        assertThat(rule.getPositionToMove()).isEqualTo(1);
        assertThat(rule.getPositionToMove()).isEqualTo(1);
    }
}
