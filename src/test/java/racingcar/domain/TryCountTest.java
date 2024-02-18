package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("시도 횟수")
class TryCountTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createTryCountTest() {
        //given
        String userTryCount1 = "5";
        String userTryCount2 = "9";
        String userTryCount3 = "15";

        //when
        TryCount tryCount1 = TryCount.from(userTryCount1);
        TryCount tryCount2 = TryCount.from(userTryCount2);
        TryCount tryCount3 = TryCount.from(userTryCount3);

        //then
        assertAll(
                () -> assertEquals(tryCount1.getTryCount(), Integer.parseInt(userTryCount1)),
                () -> assertEquals(tryCount2.getTryCount(), Integer.parseInt(userTryCount2)),
                () -> assertEquals(tryCount3.getTryCount(), Integer.parseInt(userTryCount3))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "1.5", "", " ", "1 2"})
    @DisplayName("자연수가 아닐 경우 예외가 발생한다")
    public void testNotNaturalNumberTryCount(final String tryCount) {
        //given&when&then
        assertThrows(NumberFormatException.class, () -> TryCount.from(tryCount));
    }
}