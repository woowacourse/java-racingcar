/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.BehaviorJudgment;

public class BehaviorJudgmentTest {

    @DisplayName("전진할 것인지 판단해 주는 메서드")
    @Test
    void isForward() {
        assertThat(BehaviorJudgment.isForward(4)).isTrue();
        assertThat(BehaviorJudgment.isForward(3)).isFalse();
    }
}
