package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.GameTotalCount;

import static racingcar.util.VerificationUtil.*;

@SuppressWarnings("NonAsciiCharacters")
class VerificationUtilTest {

    @Test
    @DisplayName("한 글자 미만의 자동차 이름 테스트")
    public void 한글자_미만의_자동차_이름_테스트() {
        //given
        String name = "";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateCarName(name));
    }

    @Test
    @DisplayName("다섯 글자 이상의 자동차 이름 테스트")
    public void 다섯글자_이상의_자동차_이름_테스트() {
        //given
        String name = "wooteco";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateCarName(name));
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함되어있는지 테스트")
    public void 자동차_이름_공백_테스트() {
        //given
        String name = "woo   te   co";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateCarName(name));
    }
}