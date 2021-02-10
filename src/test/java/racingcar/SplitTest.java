package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.SplitUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("자동차 이름 문자열 분리 테스트")
public class SplitTest {

    @DisplayName("콤마를 포함하지 않는 문자열 테스트")
    @Test
    void nonCommaTest() {
        assertEquals(SplitUtil.splitCarNames("asdfasdf").size(), 1);
    }

    @DisplayName("콤마 뒤에 공백을 포함하는 문자열 테스트")
    @Test
    void spaceTest() {
        assertEquals(SplitUtil.splitCarNames("car, papi, bet, pobi"),
                SplitUtil.splitCarNames("car,papi,bet,pobi"));
    }
}
