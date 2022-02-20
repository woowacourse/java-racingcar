package racingCar.domain.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import racingCar.utils.Util;

@SuppressWarnings("NonAsciiCharacters")
public class UtilTest {

    @Test
    void 쉼표_기준으로_이름_분리() {
        //given
        String names = "pobi,crong,honux";
        //when
        String[] nameArray = Util.separate(names);
        //then
        assertArrayEquals(nameArray, new String[]{"pobi", "crong", "honux"});
    }
}