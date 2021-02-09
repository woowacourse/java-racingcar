package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.SplitUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitTest {

    @DisplayName("문자열 split 테스트")
    @Test
    void split() {
        assertEquals(SplitUtil.splitCarNames("car,papi,  bet, pobi").size(), 4);
    }

}
