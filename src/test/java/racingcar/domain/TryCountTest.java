package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("시도 횟수")
class TryCountTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createTryCountTest() {
        //given
        int userTryCount1 = 5;
        int userTryCount2 = 9;
        int userTryCount3 = 15;

        //when
        TryCount tryCount1 = TryCount.from(userTryCount1);
        TryCount tryCount2 = TryCount.from(userTryCount2);
        TryCount tryCount3 = TryCount.from(userTryCount3);

        //then
        assertAll(
                () -> assertEquals(tryCount1.tryCount(), userTryCount1),
                () -> assertEquals(tryCount2.tryCount(), userTryCount2),
                () -> assertEquals(tryCount3.tryCount(), userTryCount3)
        );
    }
}