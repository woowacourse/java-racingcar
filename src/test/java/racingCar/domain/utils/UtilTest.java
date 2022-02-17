package racingCar.domain.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class UtilTest {
    @Test
    void 랜덤값_테스트() {
        for (int i = 0; i < 100; i++) {
            int result = Util.getRandomInteger();
            System.out.println("result :" + result);
            assertThat(result).isBetween(0, 9);
        }
    }

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