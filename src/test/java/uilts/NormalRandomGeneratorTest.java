package uilts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NormalRandomGenerator;
import utils.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class NormalRandomGeneratorTest {

    @DisplayName("난수의 범위는 0 이상 9 이하이다.")
    @Test
    public void test1() {
        int randomNumber = new NormalRandomGenerator().createRandomNumber();

        assertThat(randomNumber).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(0);
    }

    @DisplayName("4 이상일 경우, 전진 3 이하일 경우 움직이지 않는다.")
    @Test
    public void test2() {
        assertThat(((RandomGenerator) () -> true).movable()).isEqualTo(true);
        assertThat(((RandomGenerator) () -> false).movable()).isEqualTo(false);
    }
}