package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static racingcar.util.VerificationUtil.validateCarName;

@SuppressWarnings("NonAsciiCharacters")
class VerificationUtilTest {

    @Test
    public void 한글자_미만의_자동차_이름_테스트() throws Exception {
        //given
        String name = "";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validateCarName(name);
        });
    }

    @Test
    public void 다섯글자_이상의_자동차_이름_테스트() throws Exception {
        //given
        String name = "wooteco";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validateCarName(name);
        });
    }
}