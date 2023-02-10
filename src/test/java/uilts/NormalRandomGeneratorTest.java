package uilts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NormalRandomGenerator;

import static org.assertj.core.api.Assertions.*;

class NormalRandomGeneratorTest {

    @DisplayName("난수의 범위는 0 이상 9 이하이다.")
    @Test
    public void test1() {
        int randomNumber = NormalRandomGenerator.createRandomNumber();

        assertThat(randomNumber).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(0);
    }
}