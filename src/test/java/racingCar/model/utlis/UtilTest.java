package racingCar.model.utlis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {
    @DisplayName("랜덤값_테스트")
    @Test
    public void t1() {
        for (int i = 0; i < 100; i++) {
            int result = Util.getRandomInteger();
            System.out.println("result :" + result);
            assertThat(result).isBetween(0, 9);
        }
    }

    @DisplayName("쉼표_기준으로_이름_분리")
    @Test
    public void t2() {
        //given
        String names = "pobi,crong,honux";
        //when
        String[] nameArray = Util.separate(names);
        //then
        assertArrayEquals(nameArray, new String[]{"pobi", "crong", "honux"});
    }
}