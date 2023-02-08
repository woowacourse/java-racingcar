package uilts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomUtil;

class RandomUtilTest {

    @DisplayName("난수의 범위는 0 이상 9 이하이다.")
    @Test
    public void test1(){
        int randomNumber = RandomUtil.createRandomNumber();

        Assertions.assertThat(randomNumber).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(0);
    }

    @DisplayName("4 이상일 경우, 전진 3 이하일 경우 움직이지 않는다.")
    @Test
    public void test2(){
        Assertions.assertThat(RandomUtil.canMoveForward(5))
                .isEqualTo(true);
        Assertions.assertThat(RandomUtil.canMoveForward(2))
                .isEqualTo(false);
    }
}