package racingcar;


import org.junit.jupiter.api.Test;
import racingcar.utils.SplitUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitTest {

    @Test
    void split() {
        assertEquals(SplitUtil.splitCarNames("car,papi,  bet, pobi").size(), 4);
    }
}
