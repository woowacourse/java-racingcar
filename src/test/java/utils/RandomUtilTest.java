package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {
    @Test
    void 랜덤값() {
        Integer randNum = RandomUtil.randomNumber();
        assertThat(randNum).isBetween(0, 9);
        assertThat(randNum instanceof Integer).isEqualTo(true);
    }
}
